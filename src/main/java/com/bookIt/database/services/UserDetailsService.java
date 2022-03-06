package com.bookIt.database.services;

import com.bookIt.database.entities.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

    User loadUserByEmail(String email) throws UsernameNotFoundException;

    User loadUserByUsername(String username) throws UsernameNotFoundException;
}
