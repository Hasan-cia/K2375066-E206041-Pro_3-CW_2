package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.OrderObserver;
import com.example.iceCream.Models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class OrderBuilder {
    private Order order = new Order();


    public OrderBuilder addObserver(OrderObserver observer) {
        order.getObservers().add(observer);
        return this;
    }

    public Order build(OrderDTO orderDTO, int orderId, DataStore dataStore) {
        order.setId(orderId);
        order.setDataStore(dataStore);
        order.setCustomerId(orderDTO.getCustomerId());
        return this.order;
    }
}
