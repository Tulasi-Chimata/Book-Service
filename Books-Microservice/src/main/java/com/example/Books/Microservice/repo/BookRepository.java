package com.example.Books.Microservice.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Books.Microservice.entity.Book;


public interface BookRepository extends JpaRepository<Book,Long>{

}
