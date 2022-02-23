package com.bookIt.database.repositories;

import com.bookIt.database.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    public User getUserByUsername(@Param("username") String username);

    public User getUserByEmail(@Param("username") String email);
}
