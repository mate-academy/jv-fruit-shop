package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Fruit, Integer> storageOfFruits;

    public Storage() {
        this.storageOfFruits = new HashMap<>();
    }

    public Map<Fruit, Integer> getStorageOfFruits() {
        return storageOfFruits;
    }
}
