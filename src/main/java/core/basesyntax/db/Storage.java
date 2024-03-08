package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private static Map<String, Integer> storage;

    private Storage() {
        storage = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public static void addElements(Map<String, Integer> products) {
        storage = products;
    }

    public static Map<String, Integer> getElements() {
        return storage;
    }
}
