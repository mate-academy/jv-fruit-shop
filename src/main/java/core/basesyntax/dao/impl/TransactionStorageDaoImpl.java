package core.basesyntax.dao.impl;

import core.basesyntax.dao.TransactionStorageDao;
import core.basesyntax.db.TransactionStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionStorageDaoImpl implements TransactionStorageDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        TransactionStorage.transactions.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getAllAsList() {
        return new ArrayList<>(TransactionStorage.transactions);
    }
}
