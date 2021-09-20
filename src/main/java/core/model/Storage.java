package core.model;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<Fruit, Integer> fruitStorageMap = new HashMap<>();

    public static Map<Fruit, Integer> getFruitStorageMap() {
        return fruitStorageMap;
    }
}
