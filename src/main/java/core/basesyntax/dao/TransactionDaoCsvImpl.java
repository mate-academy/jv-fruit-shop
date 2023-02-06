package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class TransactionDaoCsvImpl implements TransactionDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.transactions.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get() {
        return null;
    }
}

