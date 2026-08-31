package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> storage = new HashMap<>();

    private Storage() {
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
