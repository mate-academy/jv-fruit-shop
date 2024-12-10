package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getStoredQuantity(String fruitName) {
        return Storage.STORED_FRUITS.get(fruitName);
    }

    @Override
    public void addFruit(String fruitName, Integer quantity) {
        Storage.STORED_FRUITS.put(fruitName, quantity);
    }

    @Override
    public void removeFruitLot(String fruitName) {
        Storage.STORED_FRUITS.remove(fruitName);
    }
}
