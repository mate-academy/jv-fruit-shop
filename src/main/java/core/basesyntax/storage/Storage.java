package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
