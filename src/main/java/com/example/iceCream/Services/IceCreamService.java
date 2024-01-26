package com.example.iceCream.Services;

import com.example.iceCream.Concrete.FlavorHandler;
import com.example.iceCream.Concrete.IceCreamDirector;
import com.example.iceCream.Concrete.SyrupHandler;
import com.example.iceCream.Concrete.ToppingHandler;
import com.example.iceCream.DataStore;
import com.example.iceCream.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IceCreamService {
    private final DataStore dataStore;

    @Autowired
    public IceCreamService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void createIceCream(ArrayList<IceCreamDTO> iceCreamDTOS,int orderId) {
        FlavorHandler flavorHandler = new FlavorHandler(dataStore);
        ToppingHandler toppingHandler = new ToppingHandler(dataStore);
        SyrupHandler syrupHandler = new SyrupHandler(dataStore);
        flavorHandler.setNext(toppingHandler);
        toppingHandler.setNext(syrupHandler);
        IceCreamDirector iceCreamDirector = new IceCreamDirector(dataStore, flavorHandler);

        for (IceCreamDTO iceCreamDTO : iceCreamDTOS)
        {
            System.out.print("IceCream with ");
            IceCream iceCream = iceCreamDirector.customizeIceCream(iceCreamDTO);
            iceCream.setOrderId(orderId);
            iceCream.setQuantity(iceCreamDTO.getQuantity());
            dataStore.getIceCreams().put(iceCream.getId(),iceCream);
        }

    }
}
