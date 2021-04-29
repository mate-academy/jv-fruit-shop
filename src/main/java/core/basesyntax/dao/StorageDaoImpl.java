package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.product.Fruit;
import java.util.Map;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int count) {
        Storage.fruits.put(fruit, count);
    }

    @Override
    public Optional<Integer> get(Fruit fruit) {
        return Optional.ofNullable(Storage.fruits.get(fruit));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
