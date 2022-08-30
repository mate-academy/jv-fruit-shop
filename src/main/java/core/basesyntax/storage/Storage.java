package core.basesyntax.storage;

import core.basesyntax.model.FruitType;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<FruitType, Integer> storage = new HashMap<>();

    public static Map<FruitType, Integer> getStorage() {
        return storage;
    }

    public static void setStorage(Map<FruitType, Integer> storage) {
        Storage.storage = storage;
    }
}
