package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStock = new HashMap<>();

    public static Map<String, Integer> getFruitStock() {
        return Collections.unmodifiableMap(fruitStock);
    }

    public static void modifyFruitStock(String fruit, int quantity) {
        fruitStock.put(fruit, quantity);
    }
}
