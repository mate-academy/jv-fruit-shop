package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final String NOT_NULL_MESSAGE = "Null can not be add";
    private static final Map<String, Integer> storage = new HashMap<>();

    public Integer getFruitsNumber(String fruit) {
        if (storage.isEmpty() || !storage.containsKey(fruit)) {
            return 0;
        }
        return storage.get(fruit);
    }

    public void storeFruit(String fruit, Integer amount) {
        if (fruit == null) {
            throw new RuntimeException(NOT_NULL_MESSAGE);
        }
        storage.put(fruit, amount);
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

}
