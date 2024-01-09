package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Set<Map.Entry<String, Integer>> getFruitsEntrySet() {
        return fruits.entrySet();
    }

    public static void updateFruit(String type, int amount) {
        fruits.put(type, amount);
    }
}
