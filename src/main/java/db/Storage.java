package db;

import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits;

    public static Map<String, Integer> getFruits() {
        return fruits;
    }

    public static void setFruits(Map<String, Integer> fruits) {
        Storage.fruits = fruits;
    }
}
