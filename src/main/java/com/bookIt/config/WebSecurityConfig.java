package com.bookIt.config;

import com.bookIt.database.seriveimpls.UserDetailsServiceImpl;
import com.bookIt.database.services.UserDetailsService;
import com.bookIt.login.handler.CustomAuthSuccessHandler;
import com.bookIt.login.handler.CustomAuthFailureHandler;
import com.bookIt.login.handler.CustomAuthLogoutSuccessHandler;
import com.bookIt.login.provider.EmailPasswordAuthenticationProvider;
import com.bookIt.login.LoginType;
import com.bookIt.login.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${bookIt.loginType:USERNAMEPASSWORD}")
    private LoginType bookItLoginType;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if(bookItLoginType == LoginType.USERNAMEPASSWORD) {
           auth.authenticationProvider(usernamePasswordAuthenticationProvider());
        }else{
            auth.authenticationProvider(emailPasswordAuthenticationProvider());
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
                        "/styles/**/*.css",
                        "/images/**")
                .permitAll()
                .antMatchers("/account", "/account/**").authenticated()
                .antMatchers("/seminars").hasAnyAuthority("USER")
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
                    .logoutSuccessHandler(customLogoutSuccessHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        http.sessionManagement().maximumSessions(1).expiredUrl("/dashboard");
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
    public UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider() {
        return new UsernamePasswordAuthenticationProvider();
    }

    @Bean
    public EmailPasswordAuthenticationProvider emailPasswordAuthenticationProvider() {
        return new EmailPasswordAuthenticationProvider();
    }
}
