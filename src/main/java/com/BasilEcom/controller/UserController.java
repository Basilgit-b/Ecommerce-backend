package com.BasilEcom.controller;

import com.BasilEcom.dto.UserRequestDTO;
import com.BasilEcom.dto.UserResponseDTO;
import com.BasilEcom.entity.User;

import com.BasilEcom.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody UserRequestDTO dto)
    {
        return userService.register(dto);
    }
}
