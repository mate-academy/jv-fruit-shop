package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitStock {

    private final Map<String, Integer> stock = new HashMap<>();

    public void add(String fruit, int quantity) {
        stock.put(fruit, stock.getOrDefault(fruit, 0) + quantity);
    }

    public int get(String fruit) {
        return stock.getOrDefault(fruit, 0);
    }

    public void remove(String fruit, int quantity) {
        int currentQuantity = stock.getOrDefault(fruit, 0);
        if (currentQuantity >= quantity) {
            stock.put(fruit, currentQuantity - quantity);
        } else {
            throw new IllegalArgumentException("Недостатньо фруктів для операції.");
        }
    }

    public int getFruitQuantity(String fruit) {
        return stock.getOrDefault(fruit, 0);
    }

    public void updateFruitQuantity(String fruit, int newQuantity) {
        stock.put(fruit, newQuantity);
    }
}
