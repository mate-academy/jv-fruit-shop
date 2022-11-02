package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.db.FruitTransactionStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        FruitTransactionStorage.fruitTransactionList.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(int index) {
        return FruitTransactionStorage.fruitTransactionList.get(index);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return FruitTransactionStorage.fruitTransactionList;
    }
}
