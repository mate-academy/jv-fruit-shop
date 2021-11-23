package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void saveFruit(String name, Integer quantity) {
        Storage.storage.put(name, quantity);
    }

    @Override
    public Integer getQuantityByName(String name) {
        return Storage.storage.getOrDefault(name, DEFAULT_VALUE);
    }

    @Override
    public void updateQuantityByName(String name, Integer quantity) {
        Integer oldQuantity = getQuantityByName(name);
        saveFruit(name, oldQuantity + quantity);
    }
}
