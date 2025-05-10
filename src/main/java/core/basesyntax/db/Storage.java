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

    public static Map.Entry<String, Integer> iterateAndFindFruits(String fruit) {
        Map.Entry<String, Integer> entry = null;
        for (Map.Entry<String, Integer> entrySetElement : getFruitsEntrySet()) {
            if (entrySetElement.getKey().equals(fruit)) {
                entry = entrySetElement;
            }
        }
        return entry;
    }
}
