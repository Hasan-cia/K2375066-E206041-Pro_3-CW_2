package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.IceCreamHandler;
import com.example.iceCream.Models.IceCream;
import com.example.iceCream.Models.IceCreamDTO;
import com.example.iceCream.Models.Topping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ToppingHandler implements IceCreamHandler {
    private final DataStore dataStore;

    @Autowired
    public ToppingHandler(DataStore dataStore) {
        this.dataStore = dataStore;
    }
    private IceCreamHandler next;
    private ArrayList<Topping> toppings = new ArrayList<>();
    private IceCream iceCream;

    @Override
    public void setIceCream(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }

    @Override
    public IceCream getIceCream() {
        return next.getIceCream();
    }

    public void setNext(IceCreamHandler next) {
        this.next = next;
    }
    @Override
    public void handleRequest(IceCreamDTO iceCreamDTO) {
        if (iceCreamDTO.getToppingIds().isEmpty()) {
            System.out.println(" Please select a Topping.");
        } else if (next != null) {
            ArrayList<Topping> toppings = dataStore.getToppingsList(iceCreamDTO.getToppingIds());
            iceCream.setToppings(toppings);
            System.out.print(" including");
            for (Topping topping : iceCream.getToppings())
            {
                System.out.print(" " + topping.getName());
            }
            System.out.print(" Toppings");
            next.setIceCream(iceCream);
            next.handleRequest(iceCreamDTO);
        }
    }
}
