package com.example.iceCream.Models;

import lombok.Getter;

public enum OrderType {
    GIFT_WRAPPING(1,"GIFT_WRAPPING"),
    SPECIAL_PACKAGING(2,"SPECIAL_PACKAGING"),
    NORMAL(3,"NORMAL");

    @Getter
    private int id;

    @Getter
    private String description;

    OrderType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
