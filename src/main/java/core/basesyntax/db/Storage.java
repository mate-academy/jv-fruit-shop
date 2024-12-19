package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static Map<String, Integer> getFruitsStorage() {
        return Collections.unmodifiableMap(fruits);
    }
}
