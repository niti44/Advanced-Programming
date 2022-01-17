package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/*@Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.*/
@Configuration
public class BookConfiguration {
    /*
    * A JavaBean is just a standard
        All properties are private (use getters/setters)
        A public no-argument constructor
        Implements Serializable.
        * "serialization" -- a process that converts an instance
        * into a stream of bytes.
        * Those bytes can be stored in files,
        * sent over a network connection, etc.,
        *  and have enough information to allow a JVM
        * (at least, one that knows about the object's type)
        * to reconstruct the object later -- possibly in a
        * different instance of the application, or even on a
        * whole other machine!
    * */
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        /*CommandLineRunner is an interface used to indicate that a bean
        should run when it is contained within a SpringApplication.*/
        return args -> {
            Book HP = new Book("Harry potter",1,"J.K rowling",
                    800.0,"harry publication");
            bookRepository.saveAll(Arrays.asList(HP));
        };

    }
}
