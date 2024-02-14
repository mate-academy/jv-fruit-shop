package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitQuantityByName = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return fruitQuantityByName;
    }
}
