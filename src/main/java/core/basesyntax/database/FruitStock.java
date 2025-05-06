package core.basesyntax.database;

import java.util.HashMap;
import java.util.Map;

public class FruitStock {
    public static final Map<String, Integer> stock = new HashMap<>();

    public void add(String fruit, int quantity) {
        stock.put(fruit, stock.getOrDefault(fruit, 0) + quantity);
    }

    public void subtract(String fruit, int quantity) {
        int current = stock.getOrDefault(fruit, 0);
        int result = current - quantity;
        if (result < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock.");
        }
        stock.put(fruit, result);
    }

    public int getQuantity(String fruit) {
        return stock.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(stock);
    }

    public void updateFruitQuantity(String fruit, int newQuantity) {
        if (fruit == null || !stock.containsKey(fruit)) {
            throw new IllegalArgumentException("Fruit not found: " + fruit);
        }
        stock.put(fruit, newQuantity);
    }

    public Map<String, Integer> getStock() {
        return stock;
    }
}
