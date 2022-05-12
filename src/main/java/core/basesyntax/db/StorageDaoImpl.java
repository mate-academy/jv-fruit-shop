package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
