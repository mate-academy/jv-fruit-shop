package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(String fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Optional<Integer> getQuantity(String fruit) {
        return Optional.ofNullable(Storage.storage.get(fruit));
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.storage;
    }
}
