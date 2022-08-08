package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

import java.util.List;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(FruitTransaction fruit) {
        Storage.fruitStorage.add(fruit);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.fruitStorage;
    }
}
