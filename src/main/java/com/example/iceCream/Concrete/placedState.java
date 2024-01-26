package com.example.iceCream.Concrete;

import com.example.iceCream.Interfaces.OrderState;
import com.example.iceCream.Models.Order;
import com.example.iceCream.Models.OrderStatus;

public class placedState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("Placing new order");
        order.setStatus(OrderStatus.PLACED);
    }
}
