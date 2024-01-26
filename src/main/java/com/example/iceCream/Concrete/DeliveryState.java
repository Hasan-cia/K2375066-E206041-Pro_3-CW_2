package com.example.iceCream.Concrete;

import com.example.iceCream.Interfaces.OrderState;
import com.example.iceCream.Models.Order;
import com.example.iceCream.Models.OrderStatus;

public class DeliveryState implements OrderState {

    @Override
    public void handleOrder(Order order) {
        System.out.println("Order is out for delivery");
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}
