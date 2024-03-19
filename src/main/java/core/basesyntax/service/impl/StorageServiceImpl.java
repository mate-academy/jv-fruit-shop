package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Storage storage = new Storage();

    public StorageServiceImpl() {
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
    public Map<String, Integer> getAll() {
        return storage.getProducts();
    }

    @Override
    public void update(String name, Integer value) {
        storage.getProducts().put(name, value);
    }
}
