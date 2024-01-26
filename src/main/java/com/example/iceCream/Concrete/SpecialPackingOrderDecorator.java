package com.example.iceCream.Concrete;

import com.example.iceCream.Models.Order;

public class SpecialPackingOrderDecorator extends OrderDecorator{
    public SpecialPackingOrderDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Special Packaging";
    }

    @Override
    public double getTotal()
    {
        return super.getTotal() + 0.5;
    }
}
