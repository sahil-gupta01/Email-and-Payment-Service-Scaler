package com.foodOrderingApp.app.services;

import com.foodOrderingApp.app.exceptions.InvalidUserException;
import com.foodOrderingApp.app.models.User;
import com.foodOrderingApp.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long userId) throws InvalidUserException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new InvalidUserException();
        }
        return user.get();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
