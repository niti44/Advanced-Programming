package com.example.demo.book;

import javax.persistence.*;

//For hibernate
@Entity //this tells hibernate to create a table out of this class
//For table in our database
@Table //specifies the name of the database table to be used for mapping.
@Embeddable
public class Book {
    @Id //specifies the primary key of an entity
    @GeneratedValue(strategy= GenerationType.AUTO) //provides for the specification of generation strategies for the values of primary keys.
    Integer id;
    String bookName;
    String author;
    Double price;
    String publication;
    public Book (){}
    public Book(String bookName, int id, String author, Double price, String publication) {
        this.bookName = bookName;
        this.id = id;
        this.author = author;
        this.price = price;
        this.publication = publication;
    }
    public Book(String bookName, String author, Double price, String publication) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.publication = publication;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publication='" + publication + '\'' +
                '}';
    }
}
