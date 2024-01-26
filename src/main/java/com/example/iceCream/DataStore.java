package com.example.iceCream;

import com.example.iceCream.Models.*;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

@Repository
@Data
public class DataStore {
    private final HashMap<Integer, Customer> customers = new HashMap<>();
    private final HashMap<Integer, Flavor> flavors = new HashMap<>();
    private final HashMap<Integer, Topping> toppings = new HashMap<>();
    private final HashMap<Integer, Syrup> syrups = new HashMap<>();
    private final HashMap<Integer, IceCream> iceCreams = new HashMap<>();
    private final HashMap<Integer, Payment> payments = new HashMap<>();
    private final Stack<Order> palcedOrderStack = new Stack<>();
    private final Stack<Order> inPreperationOrderStack = new Stack<>();
    private final Stack<Order> deliveryOrderStack = new Stack<>();
    private final HashMap<Integer, ArrayList<IceCreamTopping>> iceCreamToppings = new HashMap<>();

    public Customer getCustomerById(int customerId) {
        return customers.get(customerId);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void addOrder(Order order) {
        palcedOrderStack.push(order);
    }

    public Order popLastOrder() {
        if (!palcedOrderStack.isEmpty()) {
            return palcedOrderStack.pop();
        }
        return null; // Or throw an exception, depending on your requirements
    }
    public ArrayList<IceCream> getIceCreamsByOrderId(int orderId)
    {
        ArrayList<IceCream> iceCreams = new ArrayList<>();
        this.iceCreams.forEach((key,value)->{
            if (value.getOrderId() == orderId){
                iceCreams.add(value);
            }

        });
        return iceCreams;
    }

    public ArrayList<IceCreamTopping> getIceCreamToppingById(int id)
    {
        return iceCreamToppings.get(id);
    }
    public void addIceCreamTopping(int id,ArrayList<IceCreamTopping> iceCreamToppingArrayList)
    {
        iceCreamToppings.put(id,iceCreamToppingArrayList);
    }
    @PostConstruct
    public void init() {
        System.out.println("----Flavors----");
        Flavor flavor1 = new Flavor(1,"Chocolate",3.0);
        Flavor flavor2 = new Flavor(2,"Vanilla",1.0);
        Flavor flavor3 = new Flavor(3,"Strawberry",2.0);
        Flavor flavor4 = new Flavor(4,"Blue berry",2.0);
        Flavor flavor5 = new Flavor(5,"Mocha",1.5);
        this.flavors.put(1,flavor1);
        System.out.println(flavor1.toString());
        this.flavors.put(2,flavor2);
        System.out.println(flavor2.toString());
        this.flavors.put(3,flavor3);
        System.out.println(flavor3.toString());
        this.flavors.put(4,flavor4);
        System.out.println(flavor4.toString());
        this.flavors.put(5,flavor5);
        System.out.println(flavor5.toString());
        System.out.println();

        System.out.println("----Toppings----");
        Topping topping1 = new Topping(1,"Andes Mints", 0.1);
        Topping topping2 = new Topping(2,"Sprinkles", 0.3);
        Topping topping3 = new Topping(3,"Whoppers", 0.4);
        Topping topping4 = new Topping(4,"Jelly Beans", 0.2);
        Topping topping5 = new Topping(5,"Natualla", 0.5);

        this.toppings.put(1,topping1);
        System.out.println(topping1.toString());
        this.toppings.put(2,topping2);
        System.out.println(topping2.toString());
        this.toppings.put(3,topping3);
        System.out.println(topping3.toString());
        this.toppings.put(4,topping4);
        System.out.println(topping4.toString());
        this.toppings.put(5,topping5);
        System.out.println(topping5.toString());
        System.out.println();

        System.out.println("----Syrups----");
        Syrup syrup1 = new Syrup(1,"Maple syrup", 0.1);
        Syrup syrup2 = new Syrup(2,"Caramel sauce", 0.3);
        Syrup syrup3 = new Syrup(3,"Chocolate Syrup", 0.4);
        Syrup syrup4 = new Syrup(4,"Strawberry Beans", 0.2);
        Syrup syrup5 = new Syrup(5,"Fruit syrup", 0.5);

        this.syrups.put(1,syrup1);
        System.out.println(syrup1.toString());
        this.syrups.put(2,syrup2);
        System.out.println(syrup2.toString());
        this.syrups.put(3,syrup3);
        System.out.println(syrup3.toString());
        this.syrups.put(4,syrup4);
        System.out.println(syrup4.toString());
        this.syrups.put(5,syrup5);
        System.out.println(syrup5.toString());
        System.out.println();

        System.out.println("----Customers----");
        Customer customer1 = new Customer(1,"Normal");
        Customer customer2 = new Customer(2,"Daniel");
        Customer customer3 = new Customer(3,"Francis");
        Customer customer4 = new Customer(4,"Carlos");
        Customer customer5 = new Customer(5,"Christi");

        this.customers.put(1,customer1);
        System.out.println(customer1.toString());
        this.customers.put(2,customer2);
        System.out.println(customer2.toString());
        this.customers.put(3,customer3);
        System.out.println(customer3.toString());
        this.customers.put(4,customer4);
        System.out.println(customer4.toString());
        this.customers.put(5,customer5);
        System.out.println(customer5.toString());
        System.out.println();
    }

    public ArrayList<Topping> getToppingsList(ArrayList<Integer> toppingIds) {
        ArrayList<Topping> toppings = new ArrayList<>();
        for (Integer id: toppingIds)
        {
            toppings.add(this.toppings.get(id));
        }
        return toppings;
    }
}
