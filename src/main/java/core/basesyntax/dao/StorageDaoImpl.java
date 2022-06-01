package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateValues(String fruit, Integer quantity) {
        Integer remainingFruits = Storage.storage.get(fruit) == null
                ? 0 : Storage.storage.get(fruit);
        Storage.storage.put(fruit, remainingFruits + quantity);
    }

    @Override
    public Integer getRemainingFruits(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Set<Map.Entry<String, Integer>> extractData() {
        return Storage.storage.entrySet();
    }
}
