package com.example.firstAPI.services.impl;

import com.example.firstAPI.dto.request.UserRequestDTO;
import com.example.firstAPI.entities.Book;
import com.example.firstAPI.exception.ResourceNotFoundException;
import com.example.firstAPI.serviceDB.BookService;
import com.example.firstAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceEmpl implements UserService {

    @Autowired
    private BookService bookService;
    @Override
    public int addUser(UserRequestDTO requestDTO) {
        System.out.println("Save user to db");
        if(requestDTO.getFirstName().equals("Son")){
            throw new ResourceNotFoundException("Son da ton tai");
        }
        return 0;
    }

    public List<Book> testHibernate(){
        return bookService.list();
    }


}
