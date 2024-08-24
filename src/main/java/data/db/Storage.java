package data.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return new HashMap<>(fruitStorage);
    }

    public static void updateFruitStorage(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }
}
