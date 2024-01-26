package com.example.iceCream.Models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OrderDTO {
    private int id;
    private int customerId;
    private ArrayList<IceCreamDTO> iceCreams;
    private OrderType orderType;
    private PaymentType paymentType;
}
