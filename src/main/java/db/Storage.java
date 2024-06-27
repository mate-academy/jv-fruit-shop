package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) + quantity);
    }

    public static int getFruitQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getFruitStorage() {
        return new HashMap<>(fruitStorage);
    }

    public static void clear() {
        fruitStorage.clear();
    }
}
