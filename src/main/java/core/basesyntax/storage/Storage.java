package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits;

    public static void createMap() {
        fruits = new HashMap<>();
    }

    public static Map<String, Integer> getStorage() {
        return fruits;
    }

    public static int getFruits(String fruit) {
        return Storage.fruits.getOrDefault(fruit, 0);
    }

    public static void addFruits(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
