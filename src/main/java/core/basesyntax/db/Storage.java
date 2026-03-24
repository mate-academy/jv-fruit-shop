package core.basesyntax.db;

import java.util.Map;

public class Storage {
    private final Map<String,Integer> storage;

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
