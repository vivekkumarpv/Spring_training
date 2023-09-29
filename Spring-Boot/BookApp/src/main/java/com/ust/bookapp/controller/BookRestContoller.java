package com.ust.bookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.bookapp.model.Book;
import com.ust.bookapp.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookRestContoller {
	
	@Autowired
	BookService service;
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PostMapping
	public Book addBook(@Valid @RequestBody Book book ) {
		return service.addBook(book);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable @Valid int id ) {
		return service.getBookById(id);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PutMapping
	public Book updateBook(@Valid @RequestBody Book book) {
		return service.updateBook(book);	
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable @Valid int id) {
		service.deleteById(id);
	}
}
