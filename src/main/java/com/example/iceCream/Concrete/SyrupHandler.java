package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.IceCreamHandler;
import com.example.iceCream.Models.IceCream;
import com.example.iceCream.Models.IceCreamDTO;
import com.example.iceCream.Models.Syrup;
import org.springframework.beans.factory.annotation.Autowired;

public class SyrupHandler implements IceCreamHandler {
    private final DataStore dataStore;

    @Autowired
    public SyrupHandler(DataStore dataStore) {
        this.dataStore = dataStore;
    }
    private IceCreamHandler next;
    private Syrup syrup;
    private IceCream iceCream;
    @Override
    public void setIceCream(IceCream iceCream)
    {
        this.iceCream = iceCream;
    }

    @Override
    public IceCream getIceCream() {
        return iceCream;
    }

    public void setNext(IceCreamHandler next) {
        this.next = next;
    }
    @Override
    public void handleRequest(IceCreamDTO iceCreamDTO) {
        if (iceCreamDTO.getSyrupId() == 0) {
            System.out.println(" Please select a Syrup.");
        } else if (next != null) {

            Syrup syrup = dataStore.getSyrups().get(iceCreamDTO.getSyrupId());
            System.out.println(" Finally with " + syrup.getName());
            this.iceCream.setSyrup(syrup);
            next.setIceCream(this.iceCream);
            next.handleRequest(iceCreamDTO);
        }
        else{

            Syrup syrup = dataStore.getSyrups().get(iceCreamDTO.getSyrupId());
            System.out.println(" Finally with " + syrup.getName());
            this.iceCream.setSyrup(syrup);
        }
    }
}
