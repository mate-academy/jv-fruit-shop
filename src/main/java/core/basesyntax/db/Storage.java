package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String,Integer> map = new HashMap<>();

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static int addFruits(String fruit, int quantity) {
        map.put(fruit, quantity);
        return quantity;
    }

    public static int getInformation(String typeFruit, int amount) {
        return map.getOrDefault(typeFruit, amount);
    }
}
