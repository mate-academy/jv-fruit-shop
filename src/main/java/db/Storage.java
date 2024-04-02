package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();
    public static void of(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }
    public static Integer getQuantity(String fruit) {
        return fruitStorage.get(fruit);
    }

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }
}
