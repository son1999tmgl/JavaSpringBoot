package com.example.firstAPI.serviceDB;

import com.example.firstAPI.entities.Book;
import com.example.firstAPI.reponsitories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list(){
        return bookRepository.findAll();
    }
}
