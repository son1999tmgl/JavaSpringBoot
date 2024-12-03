package com.example.firstAPI.controller;


import com.example.firstAPI.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    public String createUser(@RequestBody UserRequestDTO user){
        return "created";
    }
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String id){
        return "id: " +  id;
    }
    @PutMapping("/")
    public String updateUser(@RequestBody UserRequestDTO user){
        return user.getEmail();
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        return "Deleted id: " + id;
    }
}
