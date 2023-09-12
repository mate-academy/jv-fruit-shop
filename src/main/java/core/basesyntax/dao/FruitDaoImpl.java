package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer amount) {
        Storage.STORAGE.put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.STORAGE;
    }
}
