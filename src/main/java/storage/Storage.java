package storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static Map<String, Integer> getFruitsStorage() {
        return fruitsStorage;
    }
}
