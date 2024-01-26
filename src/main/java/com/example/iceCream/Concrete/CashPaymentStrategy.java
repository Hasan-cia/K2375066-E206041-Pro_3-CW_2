package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.PaymentStrategy;
import com.example.iceCream.Models.Payment;
import org.springframework.beans.factory.annotation.Autowired;

public class CashPaymentStrategy implements PaymentStrategy {
    private DataStore dataStore;

    @Autowired
    public CashPaymentStrategy(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void pay(Payment payment) {
        System.out.println("Paid through cash Total of : "+ payment.getTotal());
        dataStore.getPayments().put(payment.getId(),payment);
    }
}
