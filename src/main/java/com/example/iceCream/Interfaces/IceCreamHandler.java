package com.example.iceCream.Interfaces;

import com.example.iceCream.Models.IceCream;
import com.example.iceCream.Models.IceCreamDTO;

public interface IceCreamHandler {
    void handleRequest(IceCreamDTO iceCreamDTO);
    void setIceCream(IceCream iceCream);

    IceCream getIceCream();
}
