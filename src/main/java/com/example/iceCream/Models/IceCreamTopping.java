package com.example.iceCream.Models;

import lombok.Data;

@Data
public class IceCreamTopping {
    private int id;
    private int iceCreamId;
    private int toppingId;
    private double cost;
}
