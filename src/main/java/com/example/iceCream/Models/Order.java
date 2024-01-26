package com.example.iceCream.Models;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.OrderObserver;
import com.example.iceCream.Services.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
public class Order {

    @Autowired
    private DataStore dataStore;
    private int id;
    private String description;
    private OrderStatus status;
    private int customerId;

    public double getTotal(DataStore dataStore)
    {
        double total = 0;
        ArrayList<IceCream> iceCreams = dataStore.getIceCreamsByOrderId(this.id);
        for (IceCream iceCream : iceCreams)
        {
            total = total + iceCream.getTotal();
        }
        return total;
    }
    private ArrayList<OrderObserver> observers = new ArrayList<>();


    public void setStatus(OrderStatus status,DataStore dataStore)
    {
        this.dataStore = dataStore;
        this.status = status;
        notifyObservers(this);
    }

    private void notifyObservers(Order order) {
        for (OrderObserver observer : this.observers)
        {
            observer.update(this);
        }
    }
    public String getCustomerName()
    {
        return dataStore.getCustomerById(this.customerId).getFullName();

    }
}
