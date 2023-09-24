package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> recordsMap = new HashMap<>();

    public static Map<String, Integer> getAll() {
        return recordsMap;
    }

    public static Integer get(String fruit) {
        return recordsMap.get(fruit);
    }

    public static void addPair(String fruit, Integer quantity) {
        recordsMap.put(fruit, quantity);
    }

    public static void updatePair(String fruit, Integer quantity) {
        recordsMap.put(fruit, quantity);
    }
}
