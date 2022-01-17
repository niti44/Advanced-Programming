package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {
    @Autowired
    private final BookStoreRepository bookStoreRepository;

    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }
    public List<BookStore> getBookStore() {
        return bookStoreRepository.findAll();
    }
}
