package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore,Integer> {

}
