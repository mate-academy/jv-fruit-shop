package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitDao {
    public static final Map<String, Integer> storage = new HashMap<>();

    public static void put(String fruitName, Integer quantity) {
        storage.put(fruitName, quantity);
    }

    public static Integer getQuantity(String fruit) {
        return storage.get(fruit);
    }

    public static Map<String, Integer> getAll() {
        return storage;
    }
}
