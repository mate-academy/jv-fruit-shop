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
    public int getAmount(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public boolean isPresent(String fruit) {
        return !Storage.fruits.containsKey(fruit);
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(Storage.fruits.keySet());

    }
}
