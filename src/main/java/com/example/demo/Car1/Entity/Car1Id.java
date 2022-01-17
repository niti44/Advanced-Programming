package com.example.demo.Car1.Entity;

import java.io.Serializable;

public class Car1Id implements Serializable {
    private int id;
    private String modelName;
    public Car1Id() {}
    public Car1Id(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }
}
