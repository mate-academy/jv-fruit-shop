package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(Fruit fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.fruits.entrySet().stream()
                .filter(k -> k.getKey().equals(fruit))
                .map(e -> e.getValue())
                .findFirst()
                .get();
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
