package core.basesyntax.service.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.InsufficientStockException;
import core.basesyntax.exceptions.ProductIsAbsentException;
import core.basesyntax.service.StorageService;

public class StorageServiceImpl implements StorageService {

    @Override
    public void add(String key, Integer value) {
        if (Storage.storage.containsKey(key)) {
            update(key, value);
        } else {
            Storage.storage.put(key, value);
        }
    }

    @Override
    public void update(String key, Integer value) {
        Storage.storage.put(key, Storage.storage.get(key) + value);
    }

    @Override
    public void remove(String key, Integer value) {
        if (Storage.storage.containsKey(key)) {
            checkProductAvailability(key, value);
        } else {
            throw new ProductIsAbsentException("Such product wasn't found");
        }
    }

    @Override
    public Integer get(String key) {
        Integer value = Storage.storage.get(key);
        return value;
    }

    private void checkProductAvailability(String key, Integer value) {
        if (Storage.storage.get(key) >= value) {
            Storage.storage.put(key, Storage.storage.get(key) - value);
        } else {
            throw new InsufficientStockException("Not enough product in stock");
        }
    }
}
