package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void saveAll(Map<String, Integer> fruitBalance) {
        Storage.fruitBalances.putAll(fruitBalance);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitBalances;
    }
}
