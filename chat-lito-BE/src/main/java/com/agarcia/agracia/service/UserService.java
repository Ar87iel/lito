package com.agarcia.agracia.service;

import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User>  getAllUsers()
    {
        return userRepository.findAll();
    }
    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public void deleteByUserId(Long id)
    {
        userRepository.delete(id);
    }
    public  User  searchByUserId(long userId)
    {
        System.out.println(" service user id "+userId);
        return  userRepository.findOne(userId);
    }

    public void updateByUserIdByUser(long userId, User user) {
        User temp  = userRepository.findOne(userId);
        temp.setLastName(user.getLastName());
        userRepository.save(temp);
    }

    public User findOneByUsername(String username) {

        return  userRepository.findOneByUsername(username);
    }

    public void delete(long id) {

    }
}
