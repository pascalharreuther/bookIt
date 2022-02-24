package com.bookIt.database.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface CustomUserDetailsService extends UserDetailsService {

    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException, UserPrincipalNotFoundException;
}
