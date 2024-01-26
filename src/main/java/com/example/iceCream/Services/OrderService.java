package com.example.iceCream.Services;

import com.example.iceCream.Concrete.*;
import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.IceCreamHandler;
import com.example.iceCream.Interfaces.OrderObserver;
import com.example.iceCream.Models.Order;
import com.example.iceCream.Models.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private IceCreamService iceCreamService;

    @Autowired
    private PaymentService paymentService;
    private final DataStore dataStore;

    @Autowired
    public OrderService(DataStore dataStore) {
        this.dataStore = dataStore;
    }


    public String createNewOrder(OrderDTO orderDTO) {

       int orderId = dataStore.getPalcedOrderStack().size() + 1;
        CustomerOrderObserver observer = new CustomerOrderObserver();
       OrderBuilder orderBuilder = new OrderBuilder();
       orderDTO.setId(orderId);
       iceCreamService.createIceCream(orderDTO.getIceCreams(),orderId);
       orderBuilder.addObserver(observer);
       Order order = orderBuilder.build(orderDTO,orderId,dataStore);
       OrderCommand command = new OrderCommand(order,dataStore);
       command.execute();
       switch (orderDTO.getOrderType())
       {
           case NORMAL:
               NormalOrderDecorator normalOrderDecorator = new NormalOrderDecorator(order);
               paymentService.payOrder(normalOrderDecorator.getTotal(dataStore),orderDTO.getPaymentType(),orderId,orderDTO.getCustomerId());
               break;
           case GIFT_WRAPPING:
               GiftWrappingOrderDecorator giftWrappingOrderDecorator = new GiftWrappingOrderDecorator(order);
               paymentService.payOrder(giftWrappingOrderDecorator.getTotal(dataStore),orderDTO.getPaymentType(),orderId,orderDTO.getCustomerId());
               break;
           case SPECIAL_PACKAGING:
               SpecialPackingOrderDecorator specialPackingOrderDecorator = new SpecialPackingOrderDecorator(order);
               paymentService.payOrder(specialPackingOrderDecorator.getTotal(dataStore),orderDTO.getPaymentType(),orderId,orderDTO.getCustomerId());
               break;
       }
       placedState placedState = new placedState();
       placedState.handleOrder(order);
       PreparationState preparationState = new PreparationState();
       preparationState.handleOrder(order);
       DeliveryState deliveryState = new DeliveryState();
       deliveryState.handleOrder(order);

       return "Done";
    }
}
