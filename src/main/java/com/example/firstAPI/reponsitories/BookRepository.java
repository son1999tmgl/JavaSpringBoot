package com.example.firstAPI.reponsitories;

import com.example.firstAPI.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
