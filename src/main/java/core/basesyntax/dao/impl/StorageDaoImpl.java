package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public int getAmount(String key) {
        return Storage.fruits.get(key);
    }

    @Override
    public boolean isPresent(String key) {
        return !Storage.fruits.containsKey(key);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(Storage.fruits.keySet());

    }
}
