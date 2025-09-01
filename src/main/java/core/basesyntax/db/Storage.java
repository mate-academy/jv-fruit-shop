package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> dataStorageMap = new HashMap<>();

    public Map<String, Integer> getDataStorageMapOrDefault(String fruit) {
        dataStorageMap.putIfAbsent(fruit, 0);
        return dataStorageMap;
    }

    public Map<String, Integer> getDataStorageMap() {
        return Collections.unmodifiableMap(dataStorageMap);
    }
}
