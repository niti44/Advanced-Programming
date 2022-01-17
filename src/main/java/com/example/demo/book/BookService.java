package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
@Service
public class BookService {
//    public List<Book> getBook(){
//        List<Book> list = Arrays.asList(new Book("Harry potter",1,"J.K rowling",500.0,"harry publication"));
//        return list;
//    }
        private final BookRepository bookRepository;
        @Autowired
        BookService(BookRepository bookRepository){
            this.bookRepository = bookRepository;
        }
        public List<Book> getBook() {
            return bookRepository.findAll();
        }

    public void addBook(Book book) {
        Optional<Book> bookByBookName = bookRepository.
                findBookByBookName(book.getBookName());
        if(bookByBookName.isPresent()){
            throw new IllegalStateException("Book name present");
        }
//        System.out.println(book);
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
            boolean exists = bookRepository.existsById(id);
            if(exists){
                bookRepository.deleteById(id);
            }
            else{
                throw  new IllegalStateException("book with id: "+id+" not found!!");
            }
    }

    @Transactional
    public void updateBook(int id, Double price) {
            Book book = bookRepository.findById(id).orElseThrow(
                    ()-> new IllegalStateException("Book with id "+
                            id+ " not found!!"));

            if(price != null){
                book.setPrice(price);
            }
    }
//    public List<Book> getBook() {
//        List<Book> list = Arrays.asList(new Book("Harry potter",1,"J.K rowling",500.0,"harry publication"));
//        return list;
//    }
    }

