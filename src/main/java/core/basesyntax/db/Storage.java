package core.basesyntax.db;

import core.basesyntax.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> storage = new HashMap<>();

    public Map<Fruit, Integer> getStorage() {
        return storage;
    }

    public void setStorage(Map<Fruit, Integer> storage) {
        this.storage = storage;
    }
}
