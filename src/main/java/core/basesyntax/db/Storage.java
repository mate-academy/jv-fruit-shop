package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<String, Integer>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
