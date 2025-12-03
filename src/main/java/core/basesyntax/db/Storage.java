package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storageFruit = new HashMap<>();

    public static Map<String, Integer> getStorageFruit() {
        return storageFruit;
    }
}
