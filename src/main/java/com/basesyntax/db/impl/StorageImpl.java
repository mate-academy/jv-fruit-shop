package com.basesyntax.db.impl;

import com.basesyntax.db.Storage;
import com.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageImpl implements Storage {
    private static final String COMMA = ",";
    private static Map<Fruit, Integer> storage = new HashMap<>();

    @Override
    public Map<Fruit, Integer> getStorage() {
        return storage;
    }

    @Override
    public List<String> getStorageAsList() {
        return storage.entrySet()
                .stream()
                .map(m -> m.getKey() + COMMA + m.getValue().toString())
                .collect(Collectors.toList());
    }
}
