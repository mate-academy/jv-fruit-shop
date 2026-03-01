package core.basesyntax.db;

import java.util.Collections;
import java.util.Map;

public class Storage {
    private Map<String, Integer> storage;

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public Map<String, Integer> getStorage() {
        return Collections.unmodifiableMap(storage);
    }

    public boolean findFruit(String fruit) {
        return storage.containsKey(fruit);
    }

    public int findQuantity(String fruit) {
        return storage.get(fruit);
    }

    public void addFruitWithQuantity(String fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }
}
