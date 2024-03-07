package core.basesyntax.dao.impl;

import core.basesyntax.bd.Storage;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitTransaction.add(fruitTransaction);
    }

    public FruitTransaction get(String fruit) {
        return Storage.fruitTransaction
                .stream()
                .filter(f -> f.getFruit().equals(fruit))
                .findFirst()
                .get();
    }

    @Override
    public void remove(FruitTransaction fruitTransaction) {
        Storage.fruitTransaction.remove(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.fruitTransaction;
    }
}
