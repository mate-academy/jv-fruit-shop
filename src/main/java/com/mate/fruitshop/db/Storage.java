package com.mate.fruitshop.db;

import com.mate.fruitshop.model.FruitEntry;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<FruitEntry> fruits = new ArrayList<>();

    public static List<FruitEntry> getFruits() {
        return fruits;
    }
}
