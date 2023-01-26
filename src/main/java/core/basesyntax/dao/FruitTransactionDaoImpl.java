package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.transactions.add(fruitTransaction);
        fruitTransaction.setTransactionId(Storage.transactions.size());
    }

    @Override
    public FruitTransaction get(int transactionId) {
        return Storage.transactions.get(transactionId + 1);
    }
}
