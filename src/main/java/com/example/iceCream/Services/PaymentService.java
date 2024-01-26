package com.example.iceCream.Services;

import com.example.iceCream.Concrete.CardPaymentStrategy;
import com.example.iceCream.Concrete.CashPaymentStrategy;
import com.example.iceCream.DataStore;
import com.example.iceCream.Models.Payment;
import com.example.iceCream.Models.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class PaymentService {
    private DataStore dataStore;

    @Autowired
    public PaymentService(DataStore dataStore) {
        this.dataStore = dataStore;
    }


    public void payOrder(double total, PaymentType paymentType,int orderId,int customerId) {
        Payment payment = new Payment();
        payment.setType(paymentType);
        payment.setOrderId(orderId);
        payment.setCustomerId(customerId);
        payment.setId(dataStore.getPayments().size()+1);
        payment.setTotal(total);
        switch (paymentType)
        {
            case CASH:
                CashPaymentStrategy cashPaymentStrategy = new CashPaymentStrategy(dataStore);
                cashPaymentStrategy.pay(payment);
                break;
            case CREDIT_CARD:
                CardPaymentStrategy cardPaymentStrategy = new CardPaymentStrategy(dataStore);
                cardPaymentStrategy.pay(payment);
                break;
        }

    }
}
