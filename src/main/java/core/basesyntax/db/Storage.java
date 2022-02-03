package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import core.basesyntax.model.Fruit;

public class Storage {
    private final Map<Fruit, Integer> storageOfFruits;

    public Storage() {
        this.storageOfFruits = new HashMap<>();
    }

    public Map<Fruit, Integer> getStorageOfFruits() {
        return storageOfFruits;
    }
}
