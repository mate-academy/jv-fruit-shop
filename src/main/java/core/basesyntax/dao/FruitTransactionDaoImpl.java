package core.basesyntax.dao;

import core.basesyntax.db.TransactionStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction transaction) {
        TransactionStorage.transactionList.add(transaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return TransactionStorage.transactionList;
    }
}
