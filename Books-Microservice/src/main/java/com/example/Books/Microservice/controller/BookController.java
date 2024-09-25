package com.example.Books.Microservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Books.Microservice.entity.Book;
import com.example.Books.Microservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		return bookService.getBookById(id)
				.map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
	    Book savedBook = bookService.addBook(book);
	    return ResponseEntity.ok(savedBook);
	}


}
