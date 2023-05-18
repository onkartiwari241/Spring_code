package com.lbms.libraryManagementSystem.service;

import com.lbms.libraryManagementSystem.entity.BookEntity;
import com.lbms.libraryManagementSystem.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Imple_BookService implements BookService{

    @Autowired
    private BookRepo bookRepo;
    @Override
    public BookEntity registerBook(BookEntity bookEntity) {

        System.out.println("Book Author : "+bookEntity.getBookAuthor());
       return bookRepo.save(bookEntity);
    }

    @Override
    public List<BookEntity> viewAllBooks() {
        List<BookEntity> allBooks = bookRepo.findAll();
        return allBooks;
    }

    @Override
    public BookEntity editBookById(int id) {
        BookEntity bookEntity = bookRepo.findById(id).get();
        return bookEntity;
    }

    @Override
    public BookEntity updatedBookDetailsById(BookEntity bookEntity, int id) {

        BookEntity bookForEdit = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Data not avilable..."));

//        bookForEdit.setId(bookEntity.getId());
        bookForEdit.setBookName(bookEntity.getBookName());
        bookForEdit.setBookAuthor(bookEntity.getBookAuthor());
        bookForEdit.setBookPrice(bookEntity.getBookPrice());
        bookForEdit.setBookRow(bookEntity.getBookRow());
        bookForEdit.setBookColumn(bookEntity.getBookColumn());

        System.out.println("row : "+bookEntity.getBookRow());

        BookEntity updatedBookDetails = bookRepo.save(bookForEdit);

        return updatedBookDetails;
    }

    @Override
    public List<BookEntity> deleteBook(int id) {

        BookEntity deleteBook = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Data not avilable...."));

        bookRepo.delete(deleteBook);

        List<BookEntity> allBooks = bookRepo.findAll();
        return allBooks;
    }
}
