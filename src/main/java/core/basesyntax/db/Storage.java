package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitStore = new HashMap<>();

    public static Map<String, Integer> getFruitStore() {
        return fruitStore;
    }

    public static void setFruitStore(Map<String, Integer> fruitStore) {
        Storage.fruitStore = fruitStore;
    }
}
