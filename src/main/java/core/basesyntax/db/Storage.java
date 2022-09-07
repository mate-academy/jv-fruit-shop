package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storageMap = new HashMap<>();

    public static Map<String, Integer> getStorageMap() {
        return storageMap;
    }

    public static void setStorageMap(Map<String, Integer> storageMap) {
        Storage.storageMap = storageMap;
    }
}
