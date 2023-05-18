package com.lbms.libraryManagementSystem.service;

import com.lbms.libraryManagementSystem.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    BookEntity registerBook(BookEntity bookEntity);
    List<BookEntity> viewAllBooks();

    BookEntity editBookById(int id);

    BookEntity updatedBookDetailsById(BookEntity bookEntity,int id);

    List<BookEntity> deleteBook(int id);
}
