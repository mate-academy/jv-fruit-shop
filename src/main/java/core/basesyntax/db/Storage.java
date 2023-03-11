package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Storage {
    public static final String[] DEFAULT_TITLES = {"fruit","quantity"};
    private static Map<String, Integer> fruits = new HashMap<>();

    public static void add(String fruit, Integer amount) {
        fruits.put(fruit, amount);
    }

    public static void remove(String fruit, Integer amount) {
        Storage.fruits.remove(fruit);
    }

    public static void change(String fruit, Integer amount) {
        fruits.put(fruit,
                Storage.fruits.get(fruit) + amount);
    }

    public static Stream<Map.Entry<String, Integer>> entryStream() {
        return fruits.entrySet().stream();
    }
}
