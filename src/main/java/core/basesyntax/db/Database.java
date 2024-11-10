package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Map<String, Integer> storage;

    static {
        storage = new HashMap<>();
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
