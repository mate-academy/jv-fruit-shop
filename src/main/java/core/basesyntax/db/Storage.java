package core.basesyntax.db;

import java.util.Map;

public class Storage {
    private final Map<String, Integer> storageMap;

    public Storage(Map<String, Integer> storageMap) {
        this.storageMap = storageMap;
    }

    public Map<String, Integer> getStorageMap() {
        return storageMap;
    }
}
