package com.example.firstAPI.controller;


import com.example.firstAPI.DEnum.ECity;
import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.dto.response.ResponData;
import com.example.firstAPI.dto.response.ResponseError;
import com.example.firstAPI.dto.response.ResponseFailure;
import com.example.firstAPI.dto.response.ResponseSuccess;
import com.example.firstAPI.exception.ResourceNotFoundException;
import com.example.firstAPI.services.UserService;
import com.example.firstAPI.services.impl.UserServiceEmpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @PostMapping("/")
    public ResponData<?> createUser(@Valid @RequestBody UserRequestDTO user){
        System.out.println("Request add user: " + user.getFirstName());
        try{
            userService.addUser(user);
            return new ResponData<>(HttpStatus.CREATED.value(), "User added successfully y");
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponData<?> getUser(@PathVariable("id") String id){
        System.out.println("get id: " + id);
        try{
            return new ResponData<>(HttpStatus.OK.value(), "user", new UserRequestDTO("Nguyen", "Son", "son1999tmgl3@gmail.com", 18, ECity.HANOI));
        } catch (Exception e) {
            return new ResponseError<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @PutMapping("/")
    public ResponData<?> updateUser(@RequestBody UserRequestDTO user){
        try{
            return new ResponData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
        } catch (Exception e) {
            return new ResponseError<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponData<?> deleteUser(@PathVariable String id){
        try{
            return new ResponData<>(HttpStatus.NO_CONTENT.value(), "delete " + id + " successfully");
        } catch (Exception e) {
            return new ResponseError<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }
}
