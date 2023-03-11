package storage;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final Map<String, Integer> FRUIT_MAP = new HashMap<>();

    public static Map<String, Integer> getFruitMap() {
        return FRUIT_MAP;
    }
}
