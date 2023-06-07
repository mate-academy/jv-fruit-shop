package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }
}
