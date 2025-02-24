package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough "
                    + fruit
                    + " in stock to remove "
                    + quantity);
        }
        int newQuantity = currentQuantity - quantity;
        if (newQuantity == 0) {
            fruits.remove(fruit);
        } else {
            fruits.put(fruit, newQuantity);
        }
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }
}

