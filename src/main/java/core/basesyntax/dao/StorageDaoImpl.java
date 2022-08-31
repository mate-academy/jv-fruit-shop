package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

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
        Integer currentAmount = Storage.storage.get(fruit);
        if (currentAmount < amount) {
            throw new RuntimeException("Can't remove fruit from the db: fruit-> " + fruit
                    + " amount -> " + amount
                    + ", because fruit amount in the db is -> " + currentAmount);
        }
        Storage.storage.put(fruit, Storage.storage.get(fruit) == null
                ? amount : currentAmount - amount);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntries() {
        return Storage.storage.entrySet();
    }
}
