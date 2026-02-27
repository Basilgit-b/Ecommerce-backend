package com.BasilEcom.service;

import com.BasilEcom.entity.User;
import com.BasilEcom.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public User register(User user)
    {
        return userRepository.save(user);
    }
}
