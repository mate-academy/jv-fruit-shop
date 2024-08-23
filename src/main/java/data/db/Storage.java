package data.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static Map<String, Integer> getFruitsStorage() {
        return new HashMap<>(fruitsStorage);
    }

    public static void updateFruitsStorage(String fruit, int quantity) {
        fruitsStorage.put(fruit, quantity);
    }
}
