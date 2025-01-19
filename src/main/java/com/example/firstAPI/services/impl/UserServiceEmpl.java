package com.example.firstAPI.services.impl;

import com.example.firstAPI.dto.request.AddressDTO;
import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.dto.response.PageResponse;
import com.example.firstAPI.dto.response.UserDetailResponse;
import com.example.firstAPI.entities.Book;
import com.example.firstAPI.exception.ResourceNotFoundException;
import com.example.firstAPI.model.Address;
import com.example.firstAPI.model.User;
import com.example.firstAPI.repository.UserRepository;
import com.example.firstAPI.serviceDB.BookService;
import com.example.firstAPI.services.UserService;
import com.example.firstAPI.util.UserStatus;
import com.example.firstAPI.util.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceEmpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public long saveUser(UserRequestDTO request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .phone(request.getPhone())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .status(request.getStatus())
                .type(UserType.valueOf(request.getType().toUpperCase()))
                .addresses(convertToAddress(request.getAddresses()))
                .build();
        userRepository.save(user);
        log.info("User saved with id {}", user.getId());
        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDTO request) {

    }

    @Override
    public void changeStatus(long userId, UserStatus status) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        return null;
    }

    @Override
    public PageResponse getAllUsers(int pageNo, int pageSize) {
        return null;
    }

    private Set<Address> convertToAddress(Set<AddressDTO> addresses) {
        Set<Address> result = new HashSet<>();
        addresses.forEach(a ->
                result.add(Address.builder()
                        .apartmentNumber(a.getApartmentNumber())
                        .floor(a.getFloor())
                        .building(a.getBuilding())
                        .streetNumber(a.getStreetNumber())
                        .street(a.getStreet())
                        .city(a.getCity())
                        .country(a.getCountry())
                        .addressType(a.getAddressType())
                        .build())
        );
        return result;
    }
}
