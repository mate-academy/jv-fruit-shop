package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoDbImpl implements ActivityDaoDb {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.db.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return new ArrayList<>(Storage.db);
    }
}
