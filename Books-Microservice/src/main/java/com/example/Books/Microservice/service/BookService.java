package com.example.Books.Microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Books.Microservice.entity.Book;
import com.example.Books.Microservice.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

}
