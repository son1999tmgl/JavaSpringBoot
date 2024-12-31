package com.example.firstAPI.services.impl;

import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.exception.ResourceNotFoundException;
import com.example.firstAPI.services.UserService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceEmpl implements UserService {

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        System.out.println("Save user to db");
        if(requestDTO.getFirstName().equals("Son")){
            throw new ResourceNotFoundException("Son da ton tai");
        }
        return 0;
    }
}
