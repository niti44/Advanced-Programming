package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping(path = "/api/book/v1")
public class BookController {
//    @GetMapping("/api/book/")
//    public List<Book> getBook(){
//        List<Book> list = Arrays.asList(new Book("Harry potter",1,"J.K rowling",500.0,"harry publication"));
//        return list;
//    }
//    @GetMapping()
//    public String getHello(){
//        return "Hello world";
//    }

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
//        this.bookService = new BookService();
        this.bookService = bookService;
    }
    @GetMapping("/api/book/")
    public List<Book> getBookService() {
        return bookService.getBook();
//        List<Book> list = Arrays.asList(new Book("Harry potter",1,"J.K rowling",500.0,"harry publication"));
//        return list;
    }

    //@RequestBody annotation allows us to retrieve the request's body
    @PostMapping("/api/book/add/")
    public String addBookService(@RequestBody Book book){
        bookService.addBook(book);
        return "new book added";
    }

    @DeleteMapping("/api/book/delete/{bookId}/")
    public void deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBook(id);
    }

  //we can use @RequestParam to extract query parameters, form parameters, and even files from the request.
    @PutMapping("/api/book/put/{bookId}")
    public void updateBook(@PathVariable("bookId") int id,
                           @RequestParam(required = false) Double price
                           ){
        bookService.updateBook(id,price);
    }
    }

