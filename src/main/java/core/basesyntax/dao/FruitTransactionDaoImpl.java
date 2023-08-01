package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.transactionStorage.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get() {
        return Storage.transactionStorage.get(Storage.transactionStorage.size() - 1);
    }
}
