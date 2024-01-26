package com.example.iceCream.Models;

import lombok.Data;

@Data
public class Payment{
    private int id;
    private int orderId;
    private int customerId;
    private double total;
    private PaymentType type;
}
