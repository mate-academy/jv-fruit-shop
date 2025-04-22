package core.basesyntax.service;

import java.util.Map;

public class Storage {
    private static Map<String, Integer> storage;

    public static Map<String, Integer> getStorage() {
        return storage;
    }

    public static void setStorage(Map<String, Integer> newStorage) {
        storage = newStorage;
    }
}
