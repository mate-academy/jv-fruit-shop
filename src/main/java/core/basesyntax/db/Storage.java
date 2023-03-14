package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public static Integer get(String fruit) {
        return fruits.get(fruit);
    }
}
