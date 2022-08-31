package core.basesyntax.storage;

import core.basesyntax.model.FruitType;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<FruitType, Integer> storage = new HashMap<>();

    public static Map<FruitType, Integer> getStorage() {
        return storage;
    }
}
