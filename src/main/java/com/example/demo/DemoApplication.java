package com.example.demo;

import com.example.demo.book.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@GetMapping
//	public String hello(){
//		return "Hello world";
//	}
//	@GetMapping
//	public List<String> hello(){
//		List<String> list = Arrays.asList("hello","world");
////		List<String> list = Stream.of("hello","world").collect(Collectors.toList());
////		return List.of("hello","world");
//		return list;
//	}
//	@GetMapping
//	public List<Book> getBook(){
//		List<Book> list = Arrays.asList(new Book("Harry potter",1,"J.K rowling",500.0,"harry publication"));
//		return list;
//	}
//@GetMapping
//public Book getBook(){
//	Book book = new Book("Harry potter",1,"J.K rowling",500.0,"harry publication");
//	return book;
//}
}
