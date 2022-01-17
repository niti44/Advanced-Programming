package com.example.demo.Car1.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Supplier {
    private String name; //supplier_name
    private String contact;
    private String address;

    public Supplier() {
    }

    public Supplier(String supplierName, String supplierContact, String supplierAddress) {
        this.name = supplierName;
        this.contact = supplierContact;
        this.address = supplierAddress;
    }
}
