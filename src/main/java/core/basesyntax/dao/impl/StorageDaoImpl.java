package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.Optional;

public class StorageDaoImpl implements StorageDao {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void add(String name, Integer quantity) {
        Storage.storage.put(name, quantity);
    }

    @Override
    public Optional<Integer> get(String name) {
        return Optional.ofNullable(Storage.storage.get(name));
    }

    @Override
    public void update(String name, Integer quantity) {
        Integer oldQuantity = get(name).orElse(DEFAULT_VALUE);
        add(name, oldQuantity + quantity);
    }
}
