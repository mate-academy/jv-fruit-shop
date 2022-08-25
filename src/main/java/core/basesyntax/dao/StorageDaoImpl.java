package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void save(String fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.storage;
    }

    @Override
    public Integer getQuantity(String fruit) {
        return Storage.storage.get(fruit);
    }

}
