package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private final Map<String, Integer> storage;

    public FruitStorage() {
        this.storage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
