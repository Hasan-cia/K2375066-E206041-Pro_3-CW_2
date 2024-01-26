package com.example.iceCream.Concrete;

import com.example.iceCream.DataStore;
import com.example.iceCream.Interfaces.IceCreamHandler;
import com.example.iceCream.Models.*;
import org.springframework.beans.factory.annotation.Autowired;

public class IceCreamDirector {
    private final DataStore dataStore;

    @Autowired
    public IceCreamDirector(DataStore dataStore) {
        this.dataStore = dataStore;
    }
    private IceCreamHandler next;

    public IceCreamDirector(DataStore dataStore, IceCreamHandler next) {
        this.dataStore = dataStore;
        this.next = next;
    }

    public IceCream customizeIceCream(IceCreamDTO iceCreamDTO) {
            IceCream iceCream = new IceCream();
            int id = dataStore.getIceCreams().size() + 1;
            iceCream.setId(id);
            next.setIceCream(iceCream);
            next.handleRequest(iceCreamDTO);
            return next.getIceCream();
    }
}
