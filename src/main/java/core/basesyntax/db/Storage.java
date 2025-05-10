package core.basesyntax.db;

import core.basesyntax.model.Product;
import java.util.HashMap;
import java.util.Map;

public final class Storage {
    private static Storage instance;
    private final Map<String, Product> storage;

    private Storage() {
        storage = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Product> getStorage() {
        return storage;
    }
}
