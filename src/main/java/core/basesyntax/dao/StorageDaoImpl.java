package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getQuantity(String fruit) {
        return FruitStorage.storageFruits.get(fruit);
    }

    @Override
    public void putInStorage(String fruit, int quantity) {
        FruitStorage.storageFruits.put(fruit, quantity);
    }
}
