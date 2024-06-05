package com.springjwt.controllers;

import com.springjwt.Error.UserNotFoundException;
import com.springjwt.entities.User;
import com.springjwt.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/updatetype/{id}")
    public String updateUserType(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.updateUserType(id);
    }

    @GetMapping("/user/getall")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/getbyid/{id}")
    public User getUserById(@PathVariable ("id") Long userId) throws UserNotFoundException {
            return  userService.getUserById(userId);
    }

    @DeleteMapping("/user/deletebyid/{id}")
    public String deleteUserById(@PathVariable ("id") Long userId) throws UserNotFoundException {
        return  userService.deleteUserById(userId);
    }


    @DeleteMapping("/user/deleteall")
    public String deleteAllUsers(){
        return userService.deleteAllUsers();
    }
    

}
