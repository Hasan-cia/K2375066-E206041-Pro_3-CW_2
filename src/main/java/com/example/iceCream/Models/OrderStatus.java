package com.example.iceCream.Models;

import lombok.Getter;

public enum OrderStatus {
    PLACED(1, "PLACED"),
    IN_PREPARATION(2, "IN_PREPARATION"),
    OUT_FOR_DELIVERY(3, "OUT_FOR_DELIVERY");

    @Getter
    private int id;

    @Getter
    private String description;

    OrderStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
