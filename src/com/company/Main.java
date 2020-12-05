package com.company;

import com.company.decorators.BasicSushiBarAutomaton;
import com.company.decorators.DrinkServingModule;
import com.company.decorators.PremiumSushiBarAutomaton;
import com.company.decorators.SushiBarAutomaton;
import com.company.structs.FoodItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SushiBarAutomaton automaton = new DrinkServingModule(new PremiumSushiBarAutomaton(new BasicSushiBarAutomaton()));

        List<FoodItem> menu = automaton.getMenu();
        System.out.println("Menu:");
        for (FoodItem item: menu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        automaton.orderSushi("salmon");
        automaton.orderSushi("tuna");
        if(automaton.getDecorator(PremiumSushiBarAutomaton.class) != null) {
            PremiumSushiBarAutomaton premiumAutomaton = (PremiumSushiBarAutomaton) automaton.getDecorator(PremiumSushiBarAutomaton.class);
            premiumAutomaton.addExtraToSushi("wasabi");
            premiumAutomaton.addExtraToSushi("wasabi");
        }
        automaton.orderSushi("eel");
        if(automaton.getDecorator(DrinkServingModule.class) != null) {
            DrinkServingModule drinkModule = (DrinkServingModule) automaton.getDecorator(DrinkServingModule.class);
            drinkModule.orderDrink("sake", 19);
            drinkModule.orderDrink("nuka-cola", 12);

            System.out.println("Total price:");
            System.out.println(drinkModule.getOrderPrice());
        }

    }
}
