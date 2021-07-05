package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, Integer quantity) {
        Storage.getFruitsDataBase().put(fruit, quantity);
    }

    @Override
    public Optional<Integer> get(Fruit fruit) {
        return Optional.ofNullable(Storage.getFruitsDataBase().get(fruit));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.getFruitsDataBase();
    }
}
