package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}

