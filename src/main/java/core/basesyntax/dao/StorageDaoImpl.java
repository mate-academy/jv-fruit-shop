package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private final Map<Fruit, Integer> storage;

    public StorageDaoImpl() {
        this.storage = Storage.getLeftovers();
    }

    @Override
    public void save(Fruit fruit, Integer amount) {
        Storage.getModifiableLeftovers().put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return storage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return storage;
    }
}
