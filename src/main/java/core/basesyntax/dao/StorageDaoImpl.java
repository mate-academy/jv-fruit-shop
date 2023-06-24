package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateStorage(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getFruitsFromStorage() {
        return Storage.fruitStorage;
    }
}
