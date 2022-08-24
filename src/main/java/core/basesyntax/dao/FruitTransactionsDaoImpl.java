package core.basesyntax.dao;

import core.basesyntax.db.StorageFruitTransaction;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionsDaoImpl implements FruitTransactionDao {
    @Override
    public void add(List<FruitTransaction> dailyTransactions) {
        StorageFruitTransaction.fruitTransactions.addAll(dailyTransactions);
    }

    @Override
    public List<FruitTransaction> getAllTransaction() {
        return StorageFruitTransaction.fruitTransactions;
    }
}
