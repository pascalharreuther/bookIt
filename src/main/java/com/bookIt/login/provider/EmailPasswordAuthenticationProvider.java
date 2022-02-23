package com.bookIt.login.provider;

import com.bookIt.database.seriveimpls.UserDetailsServiceImpl;
import com.bookIt.login.handler.CustomAuthSuccessHandler;
import com.bookIt.login.token.EmailAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailPasswordAuthenticationProvider implements AuthenticationProvider {

    Logger logger = LoggerFactory.getLogger(EmailPasswordAuthenticationProvider.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String email = authentication.getName();
        final String password = authentication.getCredentials().toString();

        UserDetails userDetails = null;
        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        try {
            userDetails = userDetailsServiceImpl.loadUserByEmail(email);
        } catch (UserPrincipalNotFoundException e) {
            logger.error("Error at LoadUserByEmail: " + e.getMessage());
            return null;
        }
        if(userDetails == null)
            return null;
        boolean passwordMatches = false;
        passwordMatches = passwordEncoder.matches(userDetails.getPassword(), password);

        if(!passwordMatches)
            return new EmailAuthenticationToken(email, password, grantedAuths);;

        grantedAuths.addAll(userDetails.getAuthorities());

        return new EmailAuthenticationToken(email, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
