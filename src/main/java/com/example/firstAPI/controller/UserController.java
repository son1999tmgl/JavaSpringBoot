package com.example.firstAPI.controller;


import com.example.firstAPI.DEnum.ECity;
import com.example.firstAPI.configuration.Translator;
import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.dto.response.ResponData;
import com.example.firstAPI.dto.response.ResponseError;
import com.example.firstAPI.entities.Book;
import com.example.firstAPI.exception.ResourceNotFoundException;
import com.example.firstAPI.services.impl.UserServiceEmpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Tag(name = "User Controllers")
public class UserController {
    @Autowired
    private UserServiceEmpl userService;
    @Autowired
    private MessageSource messageSource;

    @Operation(summary = "add user", description = "description add user")
    @PostMapping("/")
    public ResponData<?> createUser(@Valid @RequestBody UserRequestDTO user){
        System.out.println("Request add user: " + user.getFirstName());
        try{
            userService.addUser(user);
            // Lấy thông điệp từ MessageSource theo key
            String message = Translator.toLocale("success.addUser");
            return new ResponData<>(HttpStatus.CREATED.value(), message);
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
    @GetMapping("/")
    public List<Book> getAll(){
        return userService.testHibernate();
    }
}
