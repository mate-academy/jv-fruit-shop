package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> dataBase = new HashMap<>();

    public static Integer getByKey(String key) {
        return dataBase.get(key);
    }

    public static Map<String, Integer> getDataBase() {
        return dataBase;
    }

    public static void addToDataBase(String key, Integer value) {
        dataBase.put(key, value);
    }
}
