package com.ust.bookapp.service;

import java.util.List;

import com.ust.bookapp.model.Book;

public interface BookService {
	public Book addBook( Book book);
	public Book getBookById(int id);
	public List<Book> getAllBooks();
	public void deleteById(int id);
	public Book updateBook(Book book);
}
