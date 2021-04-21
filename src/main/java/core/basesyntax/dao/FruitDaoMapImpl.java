package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FruitDaoMapImpl implements FruitDao {
    private final Map<Fruit, Fruit> storage;

    public FruitDaoMapImpl() {
        storage = Storage.storage;
    }

    @Override
    public void add(Fruit fruit) {
        storage.put(fruit, fruit);
    }

    @Override
    public Optional<Fruit> get(Fruit fruit) {
        return Optional.ofNullable(storage.get(fruit));
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(storage.values());
    }
}
