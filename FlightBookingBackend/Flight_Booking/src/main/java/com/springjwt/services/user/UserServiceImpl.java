package com.springjwt.services.user;

import com.springjwt.Error.UserNotFoundException;
import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String updateUserType(Long id) throws UserNotFoundException {
         Optional<User> user =  userRepository.findById(id);
         if(user.isEmpty()){
             // throw exception
             throw new UserNotFoundException("user with given id does not exists");
//             return "Error in finding user";
         }

         User updatedUser = user.get();
         updatedUser.setType(1);
         userRepository.save(updatedUser);

         return "User type set to ADMIN(1) successfully";

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All user deleted successfully.";
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User with this id does not exists.");
        }
        return user.get();
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public String deleteUserById(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User with this id does not exists.");
        }

        userRepository.deleteById(userId);

        return "User with id " + userId + " deleted successfully.";
    }
}
