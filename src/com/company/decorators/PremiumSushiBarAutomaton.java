package com.company.decorators;

import com.company.structs.FoodItem;
import com.company.structs.Sushi;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.ArrayList;
import java.util.List;

public class PremiumSushiBarAutomaton implements SushiBarAutomaton{

    private SushiBarAutomaton automaton;
    private List<Sushi> orders = new ArrayList<>();
    private List<FoodItem> menu;

    public PremiumSushiBarAutomaton(SushiBarAutomaton automaton) {
        this.automaton = automaton;

        menu = automaton.getMenu();
        menu.add(new FoodItem("tuna", 5.19));
        menu.add(new FoodItem("wasabi", 0.40));
    }

    @Override
    public boolean orderSushi(String fish) {
        boolean fishAvailable = false;

        for (FoodItem item: menu) {
            if(item.getName().equals(fish)){
                orders.add(new Sushi(item));
                fishAvailable = true;
                break;
            }
        }
        return fishAvailable;
    }

    public boolean addExtraToSushi(String extra) {
        boolean extraAvailable = false;

        for (FoodItem item: menu) {
            if(item.getName().equals(extra)){
                orders.get(orders.size()-1).addExtra(item);
                extraAvailable = true;
                break;
            }
        }
        return extraAvailable;
    }

    @Override
    public double getOrderPrice() {
        double totalPrice = 0;

        for (Sushi item: orders) {
            totalPrice = totalPrice + item.getFish().getPrice();
            for (FoodItem extra: item.getExtras()) {
                totalPrice += extra.getPrice();
            }
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
