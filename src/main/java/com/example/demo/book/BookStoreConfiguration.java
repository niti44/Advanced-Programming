package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookStoreConfiguration {
    @Bean
    CommandLineRunner bookStore(BookStoreRepository bookStoreRepository){
        return args -> {
            BookStore bookStore = new BookStore("BookStore1");
            bookStoreRepository.save(bookStore);
        };
    }
    @Bean
    CommandLineRunner bookStoreBean(BookStoreRepository bookStoreRepository){
        return args -> {
            BookStore bookStore = new BookStore("BookStore12");
            bookStoreRepository.save(bookStore);
        };
    }
    @Bean
    CommandLineRunner bookStore2(BookStoreRepository bookStoreRepository){
        return args -> {
            BookStore bookStore = new BookStore("BookStore2");
            bookStoreRepository.save(bookStore);
        };
    }
//    @Bean
//    CommandLineRunner bookStoreBean3(BookStoreRepository bookStoreRepository){
//        return args -> {
//            BookStore bookStore = new BookStore("BookStore123");
//            bookStoreRepository.save(bookStore);
//        };
//    }
}
