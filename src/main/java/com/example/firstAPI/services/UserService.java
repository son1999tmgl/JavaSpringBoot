package com.example.firstAPI.services;

import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.dto.response.PageResponse;
import com.example.firstAPI.dto.response.UserDetailResponse;
import com.example.firstAPI.util.UserStatus;

public interface UserService {
    long saveUser(UserRequestDTO request);

    void updateUser(long userId, UserRequestDTO request);

    void changeStatus(long userId, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    PageResponse getAllUsers(int pageNo, int pageSize);

}
