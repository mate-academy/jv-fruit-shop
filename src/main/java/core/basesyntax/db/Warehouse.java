package core.basesyntax.db;

import core.basesyntax.model.entities.Product;
import java.util.HashMap;
import java.util.Map;

public class Warehouse<T extends Product> {
    private final Map<T, Integer> storage = new HashMap<>();

    public Map<T, Integer> getStorage() {
        return storage;
    }
}
