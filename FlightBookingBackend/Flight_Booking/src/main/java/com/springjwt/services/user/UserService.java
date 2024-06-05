package com.springjwt.services.user;

import com.springjwt.Error.UserNotFoundException;
import com.springjwt.entities.User;

import java.util.List;

public interface UserService {

    String updateUserType(Long id) throws UserNotFoundException;

    List<User> getAllUsers();

    String deleteUserById(Long userId) throws UserNotFoundException;

    String deleteAllUsers();

    User getUserById(Long userId) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;
}
