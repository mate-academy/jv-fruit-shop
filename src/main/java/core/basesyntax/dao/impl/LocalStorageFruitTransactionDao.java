package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.db.LocalStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class LocalStorageFruitTransactionDao implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        LocalStorage.FRUIT_TRANSACTIONS.add(fruitTransaction.clone());
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> all = new ArrayList<>();
        LocalStorage.FRUIT_TRANSACTIONS.forEach(ft -> all.add(ft.clone()));
        return all;
    }
}
