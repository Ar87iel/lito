package com.agarcia.agracia.web;

import com.agarcia.agracia.domain.User;
import com.agarcia.agracia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lito on 16/7/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody  User user)
    {
        userService.addUser(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userService.deleteByUserId(id);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable long id){

        System.out.println( " id "+id);
        return userService.searchByUserId(id);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable long userId,@RequestBody User user){
        userService.updateByUserIdByUser(userId,user);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/username/{username}",method = RequestMethod.GET)
    public User findOneByUsername(@PathVariable String username){
        return userService.findOneByUsername(username);
    }

    public static class UserRequestDTO{

        private String firstName;
        private String lastName;
        private String email;
        private String userName;
        private String username;


        private String password;
        private String status;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public String getStatus() {
            return status;
        }
    }
}
