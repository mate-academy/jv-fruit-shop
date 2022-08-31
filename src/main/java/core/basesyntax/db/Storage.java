package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<Fruit, Integer> storage = new HashMap<>();

    public static Map<Fruit, Integer> getAll() {
        return storage;
    }
}
