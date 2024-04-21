package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> STORAGE = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        return new HashMap<>(STORAGE);
    }
}
