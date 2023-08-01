package core.basesyntax.dao;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.db.Storage;

public class FruitTransactionDaoIml implements FruitTransactionDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.storage.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get() {
        return Storage.storage.get(Storage.storage.size() - 1);
    }
}
