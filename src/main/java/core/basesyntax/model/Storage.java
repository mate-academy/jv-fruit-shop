package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> storageOfFruits = new HashMap<>();

    public Map<Fruit, Integer> getStorageOfFruits() {
        return storageOfFruits;
    }
}
