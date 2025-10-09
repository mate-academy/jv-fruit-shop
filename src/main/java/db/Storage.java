package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    private Storage() {
    }

    public static int getQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static void setQuantity(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static void addQuantity(String fruit, int quantity) {
        fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    public static Map<String, Integer> getSnapshot() {
        return Collections.unmodifiableMap(fruitStorage);
    }
}
