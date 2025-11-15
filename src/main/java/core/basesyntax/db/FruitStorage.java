package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }

    public static void updateStorage(String fruitName, int quantity) {
        storage.put(fruitName, quantity);
    }
}
