package core.basesyntax.db;

import java.util.Map;

public class Storage {
    private Map<String, Integer> storage;

    public Storage(Map<String, Integer> map) {
        this.storage = map;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
