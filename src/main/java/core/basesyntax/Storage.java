package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static int getFruitQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static void addFruit(String fruit, int quanity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quanity);
    }

    public static void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, 0);

        if (currentQuantity >= quantity) {
            fruits.put(fruit, currentQuantity - quantity);
        } else {
            fruits.put(fruit, 0);
        }
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
