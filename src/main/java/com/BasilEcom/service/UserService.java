package com.BasilEcom.service;

import com.BasilEcom.dto.ProductResponseDTO;
import com.BasilEcom.dto.UserRequestDTO;
import com.BasilEcom.dto.UserResponseDTO;
import com.BasilEcom.entity.Product;
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
    public UserResponseDTO register(UserRequestDTO dto)
    {

        User user= new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser= userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }
}
