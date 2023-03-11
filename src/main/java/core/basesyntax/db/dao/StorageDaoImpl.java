package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao{
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.storage.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String type) {
        return null;
    }
}
