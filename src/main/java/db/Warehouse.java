package db;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Map<TypeFruit, Integer> STORAGE = new HashMap<>();

    public static Map<TypeFruit, Integer> getStorage() {
        return STORAGE;
    }

    public enum TypeFruit {
        banana, apple
    }
}
