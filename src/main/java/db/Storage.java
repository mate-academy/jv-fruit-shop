package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }

    public static Map<Fruit, Integer> getDB() {
        HashMap<Fruit, Integer> clonedDB = new HashMap<>();
        for (Map.Entry<Fruit, Integer> entry: fruits.entrySet()) {
            clonedDB.put(entry.getKey().clone(), entry.getValue());
        }
        return clonedDB;
    }
}
