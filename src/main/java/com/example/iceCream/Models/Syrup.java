package com.example.iceCream.Models;

import lombok.Data;

@Data
public class Syrup {
    private int id;
    private String name;
    private double price;

    public Syrup(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return id +". "+ name + ". " + price;
    }
}
