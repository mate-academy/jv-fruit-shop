package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import java.util.HashMap;

public class StorageServiceImpl implements StorageService {
    private final Storage storage;

    public StorageServiceImpl() {
        storage = new Storage();
    }

    @Override
    public void save(String name, Integer quantity) {
        storage.getProducts().put(name, quantity);
    }

    @Override
    public Integer get(String key) {
        return storage.getProducts().get(key);
    }

    @Override
    public HashMap<String, Integer> getAll() {
        return new HashMap<>(storage.getProducts());
    }

    @Override
    public void update(String name, Integer value) {
        storage.getProducts().put(name, value);
    }
}
