package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.NoSuchElementException;
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
        Integer oldQuantity = get(name).orElseThrow(
                () -> new NoSuchElementException("Fruit " + name + " doesn't exist"));
        add(name, oldQuantity + quantity);
    }

    @Override
    public boolean contains(String name) {
        return Storage.storage.containsKey(name);
    }
}
