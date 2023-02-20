package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }
}
