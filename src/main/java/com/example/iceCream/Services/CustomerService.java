package com.example.iceCream.Services;

import com.example.iceCream.DataStore;
import com.example.iceCream.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final DataStore dataStore;

    @Autowired
    public CustomerService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Customer getCustomerById(int customerId) {
        return dataStore.getCustomerById(customerId);
    }

    public void addCustomer(Customer customer) {
        dataStore.addCustomer(customer);
    }

}
