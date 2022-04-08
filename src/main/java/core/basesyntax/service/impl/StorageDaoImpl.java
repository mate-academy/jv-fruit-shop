package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageDao;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    private Storage storage = new Storage();

    @Override
    public void set(Fruit fruit, Integer amount) {
        storage.getData().put(fruit, amount);
    }

    @Override
    public void add(Fruit fruit, Integer amount) {
        Integer storedAmount = storage.getData().get(fruit);
        storage.getData().put(fruit, storedAmount + amount);
    }

    @Override
    public void reduce(Fruit fruit, Integer amount) {
        Integer storedAmount = storage.getData().get(fruit);
        storage.getData().put(fruit, storedAmount - amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return storage.getData().get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return storage.getData().entrySet();
    }
}
