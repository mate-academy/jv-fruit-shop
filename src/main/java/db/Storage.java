package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static final Map<Fruit, Integer> storage = new HashMap<>();

    public static Map<Fruit, Integer> getStorage() {
        return storage;
    }
}
