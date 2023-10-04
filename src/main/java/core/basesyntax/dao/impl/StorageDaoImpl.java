package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override

    public void add(String fruit, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Something wrong with balance for " + fruit
                    + "\n It is negative.");
        }
        Storage.records.put(fruit,quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.records;
    }
}
