package com.example.iceCream.Models;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String fullName;
    private long points;

    public Customer(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.points = 0;
    }

    @Override
    public String toString()
    {
        return id +". "+ fullName;
    }
}
