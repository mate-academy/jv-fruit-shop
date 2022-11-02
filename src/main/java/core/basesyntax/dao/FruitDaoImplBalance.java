package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImplBalance implements FruitDao {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
        return fruit;
    }
}
