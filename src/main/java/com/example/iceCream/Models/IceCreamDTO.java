package com.example.iceCream.Models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class IceCreamDTO {
    private int flavorId;
    private ArrayList<Integer> toppingIds;
    private int syrupId;
    private int quantity;
}
