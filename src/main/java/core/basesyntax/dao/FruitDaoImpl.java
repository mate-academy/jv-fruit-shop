package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer integer) {
        Storage.storage.put(fruit, integer);
    }

    @Override
    public Integer getInteger(Fruit fruit) {
        return Storage.storage.get(fruit);
    }
}
