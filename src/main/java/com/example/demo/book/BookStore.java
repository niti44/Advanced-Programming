package com.example.demo.book;

import javax.persistence.*;

@Entity
@Table(name = "book_store",
       uniqueConstraints = @UniqueConstraint(
               name = "unique_store_name",
               columnNames = "store_name"
       ))
public class BookStore {
    @Id
//    @SequenceGenerator(name = "bookStoreSequence",
//                        sequenceName = "bookStoreSequence",
//                        initialValue = 1,
//                        allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.AUTO)
//                    ,generator = "bookStoreSequence")
    Integer id;

    @Column(name = "store_name",
            nullable = false)
    String storeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BookStore(String storeName) {
        this.storeName = storeName;
    }
    public BookStore(){}
}
