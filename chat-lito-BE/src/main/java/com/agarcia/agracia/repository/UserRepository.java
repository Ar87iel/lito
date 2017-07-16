package com.agarcia.agracia.repository;

import com.agarcia.agracia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lito on 15/7/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by username
     *
     * @param username the user's username
     * @return user which contains the user with the given username or null.
     */
    User findOneByUsername(String username);

}