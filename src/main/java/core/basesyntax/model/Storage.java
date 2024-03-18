package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static void add(String key, Integer value) {
        if (storage.containsKey(key)) {
            storage.put(key, storage.get(key) + value);
        } else {
            storage.put(key, value);
        }
    }

    public static Stream<Map.Entry<String, Integer>> stream() {
        return storage.entrySet().stream();
    }

    public static void clear() {
        storage.clear();
    }
}
