package com.example.iceCream.Controllers;

import com.example.iceCream.Models.OrderDTO;
import com.example.iceCream.Services.IceCreamService;
import com.example.iceCream.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order/")
public class OrderController {
    @Autowired
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("create")
    public String createOrder(@RequestBody OrderDTO orderDTO)
    {
        return orderService.createNewOrder(orderDTO);
    }
}
