package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addFruit(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }
}
