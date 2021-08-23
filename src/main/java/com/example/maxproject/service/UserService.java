package com.example.maxproject.service;

import com.example.maxproject.entity.UserEntity;
import com.example.maxproject.exceptions.UserAlreadyExistException;
import com.example.maxproject.exceptions.UserNotFoundException;
import com.example.maxproject.model.User;
import com.example.maxproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with such username already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return User.toModelUser(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
