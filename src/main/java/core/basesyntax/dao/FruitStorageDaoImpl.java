package core.basesyntax.dao;

import core.basesyntax.dp.Storage;
import java.util.Map;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void setQuantity(String fruitName, Integer quantity) {
        Storage.storage.put(fruitName, quantity);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        if (!Storage.storage.containsKey(fruitName)) {
            throw new RuntimeException("There is no " + fruitName + " in the storage");
        }
        return Storage.storage.get(fruitName);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getAll() {
        return Map.copyOf(Storage.storage).entrySet();
    }
}
