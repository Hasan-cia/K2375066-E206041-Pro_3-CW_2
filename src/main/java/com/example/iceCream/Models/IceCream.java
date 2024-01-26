package com.example.iceCream.Models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class IceCream {
    private int id;
    private Flavor flavor;
    private ArrayList<Topping> toppings;
    private Syrup syrup;
    private int orderId;
    private int quantity;

    public double getTotal() {
        double total = 2.0;
        total = total + this.flavor.getPrice();
        for (Topping topping : this.getToppings())
        {
            total = total + topping.getPrice();
        }
        total =  total + this.syrup.getPrice();
        return total * quantity;
    }

    public String getDescription()
    {
        StringBuilder description = new StringBuilder();
        description.append("IceCream with ").append(this.flavor.getName()).append(" including");
        for (Topping topping : this.toppings)
        {
            description.append(" ").append(topping.getName());
        }
        description.append(" ").append(this.syrup.getName());

        return description.toString();
    }
}
