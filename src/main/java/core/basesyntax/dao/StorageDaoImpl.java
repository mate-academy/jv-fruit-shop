package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addAll(Map<String,Integer> map) {
        Storage.fruitTransactions.putAll(map);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitTransactions;
    }
}
