package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> storageOfFruits;

    static {
        storageOfFruits = new HashMap<>();
    }

    private Storage() {
    }

    public static Map<Fruit, Integer> getStorageOfFruits() {
        return storageOfFruits;
    }
}
