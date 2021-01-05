package core.basesyntax.db;

import core.basesyntax.model.Fruits;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static Map<Fruits, Integer> storage = new HashMap<>();

    public Map<Fruits, Integer> getStorage() {
        return storage;
    }
}
