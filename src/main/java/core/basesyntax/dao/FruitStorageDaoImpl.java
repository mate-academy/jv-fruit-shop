package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public Map<String, Integer> getFruits() {
        return Storage.storage;
    }

    @Override
    public Integer getFruitQuantity(String fruitName) {
        return Storage.storage.getOrDefault(fruitName, 0);
    }

    @Override
    public void updateFruitQuantity(String fruitName, Integer quantity) {
        Storage.storage.put(fruitName, quantity);
    }
}
