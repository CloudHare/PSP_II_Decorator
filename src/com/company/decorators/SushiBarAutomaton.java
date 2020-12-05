package com.company.decorators;

import com.company.structs.FoodItem;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;

public interface SushiBarAutomaton {
    boolean orderSushi(String fish);

    double getOrderPrice();

    List<FoodItem> getMenu();

    SushiBarAutomaton getDecorator(Class<?> decoratorClass);
}
