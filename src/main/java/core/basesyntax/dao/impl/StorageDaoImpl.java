package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getStoredQuantity(String fruitName) {
        return Storage.getStoredFruits().get(fruitName);
    }

    @Override
    public void addFruit(String fruitName, Integer quantity) {
        Storage.getStoredFruits().put(fruitName, quantity);
    }
}
