package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void setBalance(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static void addFruit(String fruit, int quantity) {
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) - quantity);
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitStorage);
    }
}
