package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Collections;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private final Map<Fruit, Integer> storage;

    public StorageDaoImpl() {
        this.storage = Storage.getLeftovers();
    }

    @Override
    public void save(Fruit fruit, Integer amount) {
        storage.put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Collections.unmodifiableMap(storage);
    }
}
