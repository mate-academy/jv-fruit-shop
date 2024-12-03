package core.basesyntax.db;

import core.basesyntax.exceptions.InvalidOperationException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static void addElement(String key, Integer value) {
        nullCheck(key, value);
        fruitsStorage.put(key, value);
    }

    public static Integer getFruitFromStorage(String fruitName) {
        nullCheck(fruitName);
        return fruitsStorage.get(fruitName);
    }

    public static Map<String, Integer> getFruitsStorage() {
        return Collections.unmodifiableMap(fruitsStorage);
    }
    private static void nullCheck(String fruitName) {
        if (fruitName == null || fruitName.isEmpty()) {
            throw new InvalidOperationException("Fruit name can't be null or empty!");
        }
    }

    private static void nullCheck(String key, Integer value) {
        if (key == null || key.isEmpty() || value == null || value == 0) {
            throw new InvalidOperationException("Key and value can't null or empty!");
        }
    }
}
