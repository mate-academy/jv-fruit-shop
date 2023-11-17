package core.basesyntax.db.dao.impl;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.db.dao.StorageDao;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void putItem(String name, int quantity) {
        InMemoryStorage.items.put(name, quantity);
    }

    @Override
    public void addItem(String name, int quantity) {
        putItem(name, getBalance(name) + quantity);
    }

    @Override
    public int getBalance(String name) {
        return InMemoryStorage.items.getOrDefault(name, 0);
    }
}
