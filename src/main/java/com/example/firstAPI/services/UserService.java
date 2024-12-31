package com.example.firstAPI.services;

import com.example.firstAPI.dto.request.UserRequestDTO;

public interface UserService {
    int addUser(UserRequestDTO requestDTO);
}
