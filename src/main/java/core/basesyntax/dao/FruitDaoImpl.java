package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void save(Fruit fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Optional<Integer> getQuantity(Fruit fruit) {
        return Optional.ofNullable(Storage.fruits.get(fruit));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return new HashMap<>(Storage.fruits);
    }
}
