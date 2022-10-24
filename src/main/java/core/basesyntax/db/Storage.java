package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<String, Integer> fruitQuantityMap;

    private Storage() {
        fruitQuantityMap = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Integer> getContent() {
        return fruitQuantityMap;
    }
}
