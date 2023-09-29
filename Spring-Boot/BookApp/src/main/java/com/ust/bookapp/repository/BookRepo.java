package com.ust.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.bookapp.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
