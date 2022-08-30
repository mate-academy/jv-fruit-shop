package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
    }

    @Override
    public void supply(String fruit, Integer amount) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) + amount);
    }

    @Override
    public void remove(String fruit, Integer amount) {
        if (Storage.storage.get(fruit) < amount) {
            throw new RuntimeException("Can't remove fruit from the db: fruit-> " + fruit
                    + " amount -> " + amount
                    + ", because fruit amount in the db is -> " + Storage.storage.get(fruit));
        }
        Storage.storage.put(fruit, Storage.storage.get(fruit) == null
                ? amount : Storage.storage.get(fruit) - amount);
    }

    @Override
    public Map<String, Integer> getData() {
        return Storage.storage;
    }
}
