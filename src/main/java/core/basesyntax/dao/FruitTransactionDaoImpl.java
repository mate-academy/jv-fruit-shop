package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public Integer get(FruitTransaction fruitTransaction) {
        return Storage.fruitsStorage.get(fruitTransaction.getFruit());
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsStorage;
    }
}
