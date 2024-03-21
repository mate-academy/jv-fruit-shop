package core.basesyntax.db;

import java.util.Map;

public class ProductStorage {
    private final Map<String, Integer> storage;

    public ProductStorage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
