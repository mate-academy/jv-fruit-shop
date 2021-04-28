package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static Map<Fruit, Integer> fruits = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
