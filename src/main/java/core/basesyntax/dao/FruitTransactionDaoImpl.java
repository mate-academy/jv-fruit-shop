package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.transactions;
    }
}
