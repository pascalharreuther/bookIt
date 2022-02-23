package com.bookIt.config;

import com.bookIt.database.seriveimpls.UserDetailsServiceImpl;
import com.bookIt.login.handler.CustomAuthSuccessHandler;
import com.bookIt.login.handler.CustomAuthFailureHandler;
import com.bookIt.login.handler.CustomAuthLogoutSuccessHandler;
import com.bookIt.login.provider.EmailPasswordAuthenticationProvider;
import com.bookIt.login.LoginType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${bookIt.loginType:USERNAMEPASSWORD}")
    private LoginType bookItLoginType;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        switch(bookItLoginType){
            case USERNAMEPASSWORD -> auth.authenticationProvider(authenticationProvider());
            case EMAILPASSWORD -> auth.authenticationProvider(new EmailPasswordAuthenticationProvider());
            default -> auth.authenticationProvider(authenticationProvider());
        }
    }
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/dashboard",
                        "/webjars/**",
                        "/components/**/*.js",
                        "/components/*.js",
                        "/styles/*.css",
                        "/styles/**/*.css")
                .permitAll()
                .antMatchers("/seminars").hasAnyAuthority("ADMIN")
                .anyRequest()
                    .authenticated()
                .and()
                .formLogin()
                    .loginPage("/dashboard")
                    .loginProcessingUrl("/login")
                    .successHandler(customAuthenticationSuccessHandler())
                    .failureHandler(customAuthenticationFailureHandler())
                .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .logoutSuccessHandler(customLogoutSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        http.sessionManagement().maximumSessions(1).expiredUrl("/dashboard");
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        return new CustomAuthSuccessHandler();
    }
    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler(){
        return new CustomAuthFailureHandler();
    }
    @Bean
    public LogoutSuccessHandler customLogoutSuccessHandler(){
        return new CustomAuthLogoutSuccessHandler();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
