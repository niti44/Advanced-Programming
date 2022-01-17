package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStoreController {
    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookService) {
        this.bookStoreService = bookService;
    }
    @GetMapping("/bookStore")
    public List<BookStore> getBookStoreService(){
        return bookStoreService.getBookStore();
    }
}
