package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Integer getByKey(String key) {
        return Storage.dataBase.get(key);
    }

    @Override
    public Map<String, Integer> getDataBase() {
        return Storage.dataBase;
    }

    @Override
    public void addToDataBase(String key, Integer value) {
        Storage.dataBase.put(key, value);
    }
}
