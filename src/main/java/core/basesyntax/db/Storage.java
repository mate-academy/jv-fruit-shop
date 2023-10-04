package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getStorageMap() {
        return fruitStorage;
    }
}
