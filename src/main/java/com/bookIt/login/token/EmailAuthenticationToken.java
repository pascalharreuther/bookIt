package com.bookIt.login.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class EmailAuthenticationToken  extends UsernamePasswordAuthenticationToken {

    public EmailAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public EmailAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
