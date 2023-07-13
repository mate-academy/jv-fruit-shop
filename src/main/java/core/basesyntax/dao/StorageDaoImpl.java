package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int amount) {
        Storage.getStorage().put(fruit, amount);
    }

    @Override
    public void supply(String fruit, int amount) {
        Storage.getStorage().put(fruit, Storage.getStorage().get(fruit) + amount);
    }

    @Override
    public void remove(String fruit, int amount) {
        Storage.getStorage().put(fruit, Storage.getStorage().get(fruit) - amount);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getStorage();
    }
}
