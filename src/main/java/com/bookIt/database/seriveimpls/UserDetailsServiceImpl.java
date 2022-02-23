package com.bookIt.database.seriveimpls;

import com.bookIt.database.details.MyUserDetails;
import com.bookIt.database.entities.User;
import com.bookIt.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Could not fins user");
        }
        return new MyUserDetails(user);
    }

    public UserDetails loadUserByEmail(String email) throws UserPrincipalNotFoundException{
        User user = userRepository.getUserByEmail(email);
        if(user == null){
            throw new UserPrincipalNotFoundException("Could not fins user");
        }
        return new MyUserDetails(user);
    }
}
