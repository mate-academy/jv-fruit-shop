package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction can`t be null");
        }

        Storage.transactionStorage.add(fruitTransaction);
    }
}
