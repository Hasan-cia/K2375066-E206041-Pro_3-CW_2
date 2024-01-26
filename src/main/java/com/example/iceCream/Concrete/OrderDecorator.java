package com.example.iceCream.Concrete;

import com.example.iceCream.Models.Order;

public abstract class OrderDecorator extends Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    public String getDescription() {
        return decoratedOrder.getDescription();
    }

    public double getTotal() {
        return 0;
    }
}
