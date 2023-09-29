package com.ust.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.bookapp.exceptionhandling.BookNotFoundException;
import com.ust.bookapp.model.Book;
import com.ust.bookapp.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepo repo;
	
//	@PostConstruct
//	public void init() {
//		Book book1= new Book(123,"HarryPotter","J. K. Rowling",98075648,1987,1500.60);
//		repo.save(book1);
//
//	}
	
	public Book addBook(Book book) {
		return repo.save(book);
	}

	
	public Book getBookById(int id) {
		if(!repo.existsById(id)) {
			throw new BookNotFoundException("Book with id "+id+" not found");
		}
		return repo.findById(id).get();
	}

	
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	
	public void deleteById(int id) {
		if(!repo.existsById(id)) {
			throw new BookNotFoundException("Book with id "+id+" not found");
		}
		repo.deleteById(id);
		
	}

	
	public Book updateBook(Book book) {
		return repo.save(book);
	}

}
