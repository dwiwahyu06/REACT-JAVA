package com.book.tugas7_dwiwahyu.controller;


import com.book.tugas7_dwiwahyu.model.Author;
import com.book.tugas7_dwiwahyu.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        updatedAuthor.setId(id);
        return authorRepository.save(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}
