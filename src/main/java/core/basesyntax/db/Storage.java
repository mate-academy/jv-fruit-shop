package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storageMap = new HashMap<>();

    public Map<String, Integer> getStorageMap() {
        return storageMap;
    }
}
