package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.domain.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }
}
