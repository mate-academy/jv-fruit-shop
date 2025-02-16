package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
