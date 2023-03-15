package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitStorage {
    private static final Map<String, Integer> fruitMap = new HashMap<>();

    public static Integer get(String key) {
        return fruitMap.get(key);
    }

    public static void put(String fruitName, Integer quantity) {
        fruitMap.put(fruitName, quantity);
    }

    public static Set<Map.Entry<String, Integer>> getEntries() {
        return fruitMap.entrySet();
    }
}
