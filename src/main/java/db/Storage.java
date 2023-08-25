package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitBalances = new HashMap<>();

    static {
        fruitBalances.put("apple", 0);
        fruitBalances.put("banana", 0);
    }

    public Storage() {
    }

    public static void addFruits(String fruit, Integer number) {
        fruitBalances.put(fruit, number);
    }

    public static void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruitBalances.getOrDefault(fruit, 0);
        if (currentQuantity > 0) {
            int newQuantity = Math.max(currentQuantity - quantity, 0);
            fruitBalances.put(fruit, newQuantity);
        }
    }

    public static int getFruitBalance(String fruit) {
        return fruitBalances.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllFruitBalances() {
        return new HashMap<>(fruitBalances);
    }

    @Override
    public String toString() {
        return "Storage{" + fruitBalances + "}";
    }
}
