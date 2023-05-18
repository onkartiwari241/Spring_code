package com.lbms.libraryManagementSystem.controller;

import com.lbms.libraryManagementSystem.entity.BookEntity;
import com.lbms.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("http://localhost:3000")
@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping("/bookregister")
    public void registerBook(@RequestBody BookEntity bookEntity)
    {
        System.out.println("book name =>  "+bookEntity.getBookName());
        bookService.registerBook(bookEntity);
    }

    @GetMapping("/viewAllBooks")
    public List<BookEntity> viewAllBooks()
    {
        List<BookEntity> allBooks = bookService.viewAllBooks();
        return allBooks;
    }

    @GetMapping("/editBookById/{id}")
    public BookEntity editBook(@PathVariable int id)
    {
        return bookService.editBookById(id);
    }

    @PutMapping("/updatedBookDetails/{id}")
    public void updatedBook(@PathVariable int id,@RequestBody BookEntity bookEntity)
    {
        System.out.println("book name =>  "+id);
        System.out.println("book name =>  "+bookEntity.getBookName());
        bookService.updatedBookDetailsById(bookEntity,id);
    }

    @DeleteMapping("/deleteBookId/{id}")
    public List<BookEntity> deleteBookById(@PathVariable int id)
    {
        return bookService.deleteBook(id);
    }
}
