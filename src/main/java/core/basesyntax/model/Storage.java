package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Storage {
    private Map<String, Integer> storage;

    public Storage() {
        storage = new HashMap<>();
    }

    public void add(String key, Integer value) {
        if (storage.containsKey(key)) {
            storage.put(key, storage.get(key) + value);
        } else {
            storage.put(key, value);
        }
    }

    public Stream<Map.Entry<String, Integer>> stream() {
        return storage.entrySet().stream();
    }
}
