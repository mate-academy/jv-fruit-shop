package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.transactions;
    }
}
