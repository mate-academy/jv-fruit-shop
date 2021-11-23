package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void addNewFruitToStorage(String name, int quantity) {
        Storage.fruitStorage.putIfAbsent(name, quantity);
    }

    @Override
    public void update(String name, int quantity) {
        Storage.fruitStorage.put(name, Storage.fruitStorage.get(name) + quantity);
    }
}
