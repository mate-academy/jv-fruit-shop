package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static Integer getFruitAmount(String fruit) {
        if (storage.isEmpty() || !storage.containsKey(fruit)) {
            return 0;
        }
        return storage.get(fruit);
    }

    public static void putFruitToStorage(String fruit, Integer amount) {
        storage.put(fruit, amount);
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }

}
