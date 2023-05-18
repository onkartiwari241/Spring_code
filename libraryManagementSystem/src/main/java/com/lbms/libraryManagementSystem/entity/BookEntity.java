package com.lbms.libraryManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BookManagement")
public class BookEntity {

    @Id
    @GeneratedValue
    private int id;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private int bookRow;
    private int bookColumn;

    public BookEntity(){}

    public BookEntity(int id, String bookName, String bookAuthor, double bookPrice, int bookRow, int bookColumn) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookRow = bookRow;
        this.bookColumn = bookColumn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookRow() {
        return bookRow;
    }

    public void setBookRow(int bookRow) {
        this.bookRow = bookRow;
    }

    public int getBookColumn() {
        return bookColumn;
    }

    public void setBookColumn(int bookColumn) {
        this.bookColumn = bookColumn;
    }
}
