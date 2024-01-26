package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.IceCreamHandler;
import com.example.iceCream.Models.Flavor;
import com.example.iceCream.Models.IceCream;
import com.example.iceCream.Models.IceCreamDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class FlavorHandler implements IceCreamHandler {
    private final DataStore dataStore;

    @Autowired
    public FlavorHandler(DataStore dataStore) {
        this.dataStore = dataStore;
    }
    private IceCreamHandler next;
    private IceCream iceCream;
    @Override
    public void setIceCream(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }

    @Override
    public IceCream getIceCream() {
        return next.getIceCream();
    }

    public void setNext(IceCreamHandler next) {
        this.next = next;
    }
    @Override
    public void handleRequest(IceCreamDTO iceCreamDTO) {
        if (iceCreamDTO.getFlavorId() == 0) {
            System.out.println(" Please select a flavor.");
        } else if (next != null) {
            iceCream.setFlavor(dataStore.getFlavors().get(iceCreamDTO.getFlavorId()));
            System.out.print(iceCream.getFlavor().getName()+" Flavor");
            next.setIceCream(iceCream);
            next.handleRequest(iceCreamDTO);
        }

    }
}
