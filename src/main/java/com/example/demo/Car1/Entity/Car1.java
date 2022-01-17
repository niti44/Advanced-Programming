package com.example.demo.Car1.Entity;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "car_table1",
uniqueConstraints = @UniqueConstraint(name = "unique_regNum",
columnNames = "reg_num"))
//@IdClass(Car1Id.class)
//@SQLDelete()

public class Car1 {
    @Id
    @SequenceGenerator(name="car_sequence_1",
    sequenceName = "car_sequence_1",
    initialValue = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
    generator = "car_sequence_1")
    private int id;
//    @Id
    private String modelName;
    @Column(name = "reg_num",nullable = false)
    private String registrationNumber; // registration_number
//    @Transient
    private String colour;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }



//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="name",
//            column =  @Column(name="supplier_name")),
//            @AttributeOverride(name = "contact",
//            column =  @Column(name = "supplier_contact")),
//            @AttributeOverride(name = "address",
//            column = @Column(name = "supplier_address"))
//    })
//    private Supplier supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



//    public Supplier getSupplierContact() {
//        return supplier;
//    }

//    public void setSupplierContact(Supplier supplier) {
//        this.supplier = supplier;
//    }



    public Car1(String modelName, String registrationNumber, String colour, Double price, Owner owner) {
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.price = price;
        this.owner = owner;

//        this.supplier = supplier;
    }
    public Car1() {
    }

    public Car1(int id, String modelName, String registrationNumber, String colour, Double price, Owner owner) {
        this.id = id;
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.price = price;
        this.owner = owner;

//        this.supplier = supplier;
    }
}
