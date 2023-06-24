package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, Integer amount) {
        fruits.put(fruit, amount);
    }

    public static Integer get(String fruit) {
        return fruits.get(fruit);
    }
}
