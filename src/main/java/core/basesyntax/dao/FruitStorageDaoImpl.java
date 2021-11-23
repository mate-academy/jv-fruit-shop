package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String name, int quantity) {
        Storage.fruitStorage.putIfAbsent(name, quantity);
    }

    @Override
    public boolean get(String name) {
        return Storage.fruitStorage.containsKey(name);
    }

    @Override
    public void update(String name, int quantity) {
        Storage.fruitStorage.put(name, Storage.fruitStorage.get(name) + quantity);
    }
}
