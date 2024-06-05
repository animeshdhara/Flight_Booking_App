package com.springjwt.controllers;

import com.springjwt.Error.UserFoundException;
import com.springjwt.Error.UserNotFoundException;
import com.springjwt.dto.SignupDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.services.auth.AuthService;
import com.springjwt.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) throws UserFoundException, UserNotFoundException {

        if(userService.getUserByEmail(signupDTO.getEmail()) != null){
//            System.out.println("something is up");
            throw  new UserFoundException("User with given mail already exists .");
//            return new ResponseEntity<>("User with given mail already exists.", HttpStatus.CREATED);
        }

       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
