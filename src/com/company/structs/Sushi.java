package com.company.structs;

import java.util.ArrayList;
import java.util.List;

public class Sushi {
    private FoodItem fish;
    private List<FoodItem> extras = new ArrayList<>();

    public Sushi(FoodItem fish) {
        this.fish = fish;
    }

    public FoodItem getFish() {
        return fish;
    }

    public void setFish(FoodItem fish) {
        this.fish = fish;
    }

    public List<FoodItem> getExtras() {
        return extras;
    }

    public void addExtra(FoodItem extra) {
        this.extras.add(extra);
    }
}
