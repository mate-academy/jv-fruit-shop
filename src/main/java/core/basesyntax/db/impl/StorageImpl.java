package core.basesyntax.db.impl;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
