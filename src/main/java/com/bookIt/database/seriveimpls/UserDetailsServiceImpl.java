package com.bookIt.database.seriveimpls;

import com.bookIt.database.entities.User;
import com.bookIt.database.repositories.UserRepository;
import com.bookIt.database.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not fins user");
        }
        return user;
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException{
        User user = userRepository.getUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Could not fins user");
        }
        return user;
    }
}
