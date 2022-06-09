package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void addAll(List<FruitTransaction> fruitTransactions) {
        Storage.fruitTransactions.addAll(fruitTransactions);
    }
}
