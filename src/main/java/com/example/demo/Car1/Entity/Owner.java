package com.example.demo.Car1.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car1> cars;

    public List<Car1> getCars() {
        return cars;
    }

    public void setCars(List<Car1> cars) {
        this.cars = cars;
    }

    public Owner() {
    }

    public Owner(int ownerId, String firstName, String lastName) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
