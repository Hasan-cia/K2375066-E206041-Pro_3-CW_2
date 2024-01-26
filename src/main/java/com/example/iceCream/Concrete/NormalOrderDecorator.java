package com.example.iceCream.Concrete;

import com.example.iceCream.Models.Order;

public class NormalOrderDecorator extends OrderDecorator{
    public NormalOrderDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Special Packaging";
    }
    @Override
    public double getTotal()
    {
       return super.getTotal();
    }
}
