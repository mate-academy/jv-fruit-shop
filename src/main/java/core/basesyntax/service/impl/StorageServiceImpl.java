package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Storage storage = new Storage();

    @Override
    public int getQuantity(String key) {
        return storage.getFruits().get(key);
    }

    @Override
    public void add(String fruitName, Integer value) {
        storage.getFruits().put(fruitName, value);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getFruits();
    }

    @Override
    public void updateQuantity(String fruitName, Integer value) {
        if (storage.getFruits().containsKey(fruitName)) {
            storage.getFruits().put(fruitName, value);
        } else {
            add(fruitName, value);
        }
    }
}
