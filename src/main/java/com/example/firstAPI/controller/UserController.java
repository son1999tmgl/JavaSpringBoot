package com.example.firstAPI.controller;


import com.example.firstAPI.DEnum.ECity;
import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.dto.response.ResponseFailure;
import com.example.firstAPI.dto.response.ResponseSuccess;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    public ResponseSuccess createUser(@Valid @RequestBody UserRequestDTO user){
        System.out.println("Request add user: " + user.getFirstName());
        try{
            return new ResponseSuccess(HttpStatus.CREATED, "User added successfully");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseSuccess getUser(@PathVariable("id") String id){
        System.out.println("get id: " + id);
        try{
            return new ResponseSuccess(HttpStatus.OK, "user", new UserRequestDTO("Nguyen", "Son", "son1999tmgl3@gmail.com", 18, ECity.HANOI));
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @PutMapping("/")
    public ResponseSuccess updateUser(@RequestBody UserRequestDTO user){
        try{
            return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseSuccess deleteUser(@PathVariable String id){
        try{
            return new ResponseSuccess(HttpStatus.NO_CONTENT, "delete " + id + " successfully");
        } catch (Exception e) {
            return new ResponseFailure(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
