package com.example.iceCream.Concrete;

import com.example.iceCream.Interfaces.OrderState;
import com.example.iceCream.Models.Order;
import com.example.iceCream.Models.OrderStatus;

public class PreparationState implements OrderState {
    @Override
    public void handleOrder(Order order) {
        System.out.println("Order is in preparation");
        order.setStatus(OrderStatus.IN_PREPARATION);
    }
}
