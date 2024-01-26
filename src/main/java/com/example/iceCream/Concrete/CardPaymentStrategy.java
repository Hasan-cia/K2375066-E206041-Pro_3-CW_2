package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.PaymentStrategy;
import com.example.iceCream.Models.Payment;
import org.springframework.beans.factory.annotation.Autowired;

public class CardPaymentStrategy implements PaymentStrategy {
    private DataStore dataStore;

    @Autowired
    public CardPaymentStrategy(DataStore dataStore)
    {
        this.dataStore = dataStore;
    }
    @Override
    public void pay(Payment payment) {

    }
}
