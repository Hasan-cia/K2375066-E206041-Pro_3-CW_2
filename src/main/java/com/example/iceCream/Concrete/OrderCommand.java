package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.Command;
import com.example.iceCream.Models.Order;
import com.example.iceCream.Models.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderCommand implements Command {

    private DataStore dataStore;
    private Order order;

    public OrderCommand(Order order,DataStore dataStore)
    {
        this.order = order; this.dataStore = dataStore;
    }
    @Override
    public void execute() {
        System.out.println("Placing order...");
        this.dataStore.getPalcedOrderStack().add(order);
    }
}
