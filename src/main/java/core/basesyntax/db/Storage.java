package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void add(String name, int quantity) {
        if (Storage.fruits.containsKey(name)) {
            quantity += Storage.fruits.get(name);
        }
        Storage.fruits.put(name, quantity);
    }
}
