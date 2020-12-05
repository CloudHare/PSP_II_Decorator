package com.company.decorators;

import com.company.structs.*;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.ArrayList;
import java.util.List;

public class BasicSushiBarAutomaton implements SushiBarAutomaton{

    private List<FoodItem> orders = new ArrayList<>();
    private List<FoodItem> menu = new ArrayList<>();

    public BasicSushiBarAutomaton() {
        menu.add(new FoodItem("salmon", 3.99));
        menu.add(new FoodItem("eel", 5.73));
    }

    @Override
    public boolean orderSushi(String fish) {
        boolean fishAvailable = false;

        for (FoodItem item: menu) {
            if(item.getName().equals(fish)){
                orders.add(item);
                fishAvailable = true;
                break;
            }
        }
        return fishAvailable;
    }

    @Override
    public double getOrderPrice() {
        double totalPrice = 0;

        for (FoodItem item: orders) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<FoodItem> getMenu() {
        List<FoodItem> menuClone = new ArrayList<>();

        for (FoodItem item: menu) {
            menuClone.add(item.clone());
        }
        return menuClone;
    }

    @Override
    public SushiBarAutomaton getDecorator(Class<?> decoratorClass) {
        return null;
    }
}
