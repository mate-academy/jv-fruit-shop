package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    public void subtractFruit(String fruit, int minuend) {
        Integer currentValue = Storage.foodStorage.get(fruit);

        if (currentValue != null && currentValue >= minuend) {
            Storage.foodStorage.put(fruit, currentValue - minuend);
        } else {
            throw new RuntimeException("Not enough " + fruit + " in the storage to remove from");
        }
    }

    public void addFruit(String fruit, int addend) {
        Storage.foodStorage.merge(fruit, addend, Integer::sum);
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(Storage.foodStorage);
    }
}
