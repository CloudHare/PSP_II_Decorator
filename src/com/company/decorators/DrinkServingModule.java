package com.company.decorators;

import com.company.structs.FoodItem;
import com.company.structs.Sushi;

import java.util.ArrayList;
import java.util.List;

public class DrinkServingModule implements SushiBarAutomaton{

    private SushiBarAutomaton automaton;
    private List<FoodItem> drinkOrders = new ArrayList<>();
    private List<FoodItem> menu;

    public DrinkServingModule(SushiBarAutomaton automaton) {
        this.automaton = automaton;

        menu = automaton.getMenu();
        menu.add(new FoodItem("sake", 3.50));
        menu.add(new FoodItem("nuka-cola", 2.80));
    }

    public boolean orderDrink(String drink, int age) {
        boolean drinkAvailable = false;

        if(!eligibleAge(drink, age)) return false;
        for (FoodItem item: menu) {
            if(item.getName().equals(drink)){
                drinkOrders.add(item);
                drinkAvailable = true;
                break;
            }
        }
        return drinkAvailable;
    }

    private boolean eligibleAge(String drink, int age) {
        switch (drink) {
            case "sake": return age >= 20;
            case "duff beer": return age >= 20;
            default: return true;
        }
    }

    @Override
    public boolean orderSushi(String fish) {
        return automaton.orderSushi(fish);
    }

    @Override
    public double getOrderPrice() {
        double totalPrice = automaton.getOrderPrice();

        for (FoodItem item: drinkOrders) {
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

        if (this.getClass().equals(decoratorClass)){
            return this;
        }
        return automaton.getDecorator(decoratorClass);
    }
}
