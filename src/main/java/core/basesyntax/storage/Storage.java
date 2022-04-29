package core.basesyntax.storage;

import core.basesyntax.models.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static Map<Fruit, Integer> storage = new HashMap<>();

    public void add(Fruit fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    public Set<Map.Entry<Fruit, Integer>> getStorageContent() {
        return storage.entrySet();
    }
}
