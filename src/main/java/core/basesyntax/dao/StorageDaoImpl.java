package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void put(Fruit key, Integer value) {
        Storage.storage.put(key, value);
    }

    @Override
    public Integer get(Fruit key) {
        return Storage.storage.get(key);
    }

    @Override
    public Set<Fruit> getAllKeys() {
        return Storage.storage.keySet();
    }
}
