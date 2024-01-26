package com.example.iceCream.Concrete;

import com.example.iceCream.Interfaces.OrderObserver;
import com.example.iceCream.Models.Order;

public class CustomerOrderObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Dear"+ order.getCustomerName() +" , your order Number"+ order.getId() +" status is now: " + order.getStatus().getDescription());
    }
}
