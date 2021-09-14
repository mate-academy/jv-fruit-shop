package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> storage = new HashMap<>();

    public static Map<Fruit, Integer> getStorage() {
        return storage;
    }
}
