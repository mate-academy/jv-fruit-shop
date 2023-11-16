package core.basesyntax.dao.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void add(FruitTransaction translation) {
        Storage.fruits.add(translation);
    }

    @Override
    public void delete(FruitTransaction transaction) {
        Storage.fruits.remove(transaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.fruits;
    }
}
