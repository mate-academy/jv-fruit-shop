package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction fruitType) {
        Storage.fruitTransactions.add(fruitType);
    }

    @Override
    public void remove(FruitTransaction fruitType) {
        Storage.fruitTransactions.remove(fruitType);
    }
}
