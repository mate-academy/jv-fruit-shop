package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static int getQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static void setQuantity(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }
    
    public static Map<String, Integer> getFruits() {
        return Collections.unmodifiableMap(fruitStorage);
    }
}
