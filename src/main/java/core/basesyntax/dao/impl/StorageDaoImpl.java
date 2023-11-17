package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void putToMap(String fruit, Integer amount) {
        Storage.fruitsDB.put(fruit, amount);
    }

    @Override
    public Integer getAmount(String fruit) {
        return Storage.fruitsDB.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsDB;
    }
}
