package core.dao;

import core.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitTransactions;
    }
}
