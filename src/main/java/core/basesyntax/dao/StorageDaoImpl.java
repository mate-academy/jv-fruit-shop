package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(FruitTransaction fruit) {
        Storage.fruits.put(fruit.getName(), fruit.getQuantity());
    }

    @Override
    public Integer get(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
