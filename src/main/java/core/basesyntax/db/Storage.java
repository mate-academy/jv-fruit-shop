package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> storage = new HashMap<>();

    public Map<Fruit, Integer> getStorage() {
        return storage;
    }
}
