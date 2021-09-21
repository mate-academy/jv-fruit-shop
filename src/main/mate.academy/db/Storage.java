package db;

import model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> storage = new HashMap<>();

    public Map<Fruit, Integer> getStorage() {
        return storage;
    }
}