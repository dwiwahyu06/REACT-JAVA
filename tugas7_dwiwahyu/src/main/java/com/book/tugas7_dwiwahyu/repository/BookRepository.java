package com.book.tugas7_dwiwahyu.repository;


import com.book.tugas7_dwiwahyu.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
