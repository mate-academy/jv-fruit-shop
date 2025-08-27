package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> dataStorageMap = new HashMap<>();

    public static Map<String, Integer> getDataStorageMap() {
        return dataStorageMap;
    }

    public static void setDataStorageMap(Map<String, Integer> dataStorageMap) {
        Storage.dataStorageMap = dataStorageMap;
    }
}
