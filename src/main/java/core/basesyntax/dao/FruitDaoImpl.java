package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(List<FruitTransaction> fruits) {
        Storage.fruitStorage.addAll(fruits);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.fruitStorage;
    }
}
