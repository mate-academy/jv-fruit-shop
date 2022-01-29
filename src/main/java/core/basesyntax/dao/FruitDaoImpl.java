package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addAll(List<FruitTransaction> fruitTransactionList) {
        Storage.storage.addAll(fruitTransactionList);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.storage;
    }
}
