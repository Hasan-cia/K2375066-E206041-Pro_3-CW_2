package com.example.iceCream.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Feedback {
    private int id;
    private int itemId;
    private int customerId;
    private String subject;
    private String text;
    private LocalDateTime dateTime;
}
