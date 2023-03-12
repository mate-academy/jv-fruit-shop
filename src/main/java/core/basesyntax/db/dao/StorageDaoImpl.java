package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao{
    @Override
    public void add(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer get(String type) {
        return Storage.fruitStorage.get(type);
    }
}

