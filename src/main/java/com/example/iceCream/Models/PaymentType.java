package com.example.iceCream.Models;

import lombok.Getter;

public enum PaymentType {
    CREDIT_CARD(1,"CREDIT_CARD"),
    CASH(2,"CASH");
    @Getter
    private int id;

    @Getter
    private String description;

    PaymentType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
