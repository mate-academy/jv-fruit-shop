package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
