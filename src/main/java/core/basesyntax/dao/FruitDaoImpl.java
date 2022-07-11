package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addAll(List<Fruit> fruits) {
        Storage.fruits.addAll(fruits);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }
}
