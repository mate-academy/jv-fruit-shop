package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public void put(String fruit, int quantity) {
        if (fruit == null || quantity < 0) {
            throw new IllegalArgumentException("Fruit is null or quantity is less than 0");
        }
        fruitStorage.put(fruit,quantity);
    }

    public void add(String fruit, int quantity) {
        int current = fruitStorage.getOrDefault(fruit,0);
        if (quantity < 0) {
            throw new IllegalArgumentException("Value should be grater than 0");
        }
        put(fruit,current + quantity);
    }

    public void subtract(String fruit, int quantity) {
        int current = fruitStorage.getOrDefault(fruit,0);
        int newValue = current - quantity;
        if (quantity < 0) {
            throw new IllegalArgumentException("Value can't be less than 0: " + quantity);
        }
        if (newValue < 0) {
            throw new IllegalArgumentException("New quantity can't be less than 0: " + newValue);
        }
        put(fruit,newValue);
    }

    public Map<String, Integer> getAll() {
        return new HashMap<>(fruitStorage);
    }
}
