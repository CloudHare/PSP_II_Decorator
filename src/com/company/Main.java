package com.company;

import com.company.decorators.BasicSushiBarAutomaton;
import com.company.decorators.PremiumSushiBarAutomaton;
import com.company.decorators.SushiBarAutomaton;
import com.company.structs.FoodItem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PremiumSushiBarAutomaton automaton = new PremiumSushiBarAutomaton(new BasicSushiBarAutomaton());

        List<FoodItem> menu = automaton.getMenu();
        System.out.println("Menu:");
        for (FoodItem item: menu) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        automaton.orderSushi("salmon");
        automaton.orderSushi("eel");
        automaton.addExtraToSushi("wasabi");
        automaton.addExtraToSushi("wasabi");
        automaton.orderSushi("tuna");
        automaton.addExtraToSushi("wasabi");
        System.out.println("Total price:");
        System.out.println(automaton.getOrderPrice());

        SushiBarAutomaton premiumDecorator = automaton.getDecorator(PremiumSushiBarAutomaton.class);
        System.out.println("Decorators used:");
        System.out.println(premiumDecorator);

    }
}
