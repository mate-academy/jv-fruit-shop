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

    @Override
    public boolean containsFruit(String fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public void mergeQuantity(String fruit, int quantity) {
        Storage.fruitStorage.merge(fruit, quantity, Integer::sum);
    }
}
