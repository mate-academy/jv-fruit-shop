package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Storage.fruits.put(fruit, Storage.fruits.get(fruit) + amount);
    }
}
