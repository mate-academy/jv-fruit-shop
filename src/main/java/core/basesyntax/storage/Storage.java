package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<Fruit, Integer> storageOfFruits = new HashMap<>();

    public static Map<Fruit, Integer> getAll() {
        return storageOfFruits;
    }
}
