package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;

public class StorageImpl implements Storage {
    @Override
    public void update(FruitTransaction fruitTransaction, int count) {
        Storage.storage.put(fruitTransaction.getFruit(), count);
    }

    @Override
    public int calculateAmount(FruitTransaction fruitTransaction) {
        return Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
    }
}
