package core.basesyntax.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FruitStorage {
    private static Map<String, Integer> fruits = new HashMap<>();

    private FruitStorage() {
    }

    public static FruitStorage getFruitStorage() {
        return new FruitStorage();
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }

    public static void addFruit(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static List<String> getAllFruits() {
        return new ArrayList<>(fruits.keySet());
    }

    public static int getQuantity(String fruitName) {
        return fruits.get(fruitName);
    }

    public static void setQuantity(String fruitName, int quantity) {
        fruits.put(fruitName, quantity);
    }

    public static void updateFruitQuantity(String fruitName, int quantity) {
        int fruit = fruits.get(fruitName);
        if (fruit >= 0) {
            fruits.put(fruitName, quantity);
        }
    }

    public static Optional<String> getFruit(String fruitName) {
        if (fruits.containsKey(fruitName)) {
            return Optional.ofNullable(fruitName);
        } else {
            return Optional.ofNullable(null);
        }
    }
}
