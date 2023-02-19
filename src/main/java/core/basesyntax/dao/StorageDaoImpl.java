package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addToStorage(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public void removeFromStorage(String fruit, int quantity) {
        Integer currentQuantity = Storage.fruitStorage.get(fruit);
        int difference = currentQuantity - quantity;
        if (difference < 0) {
            throw new RuntimeException(fruit + " not enough at the storage");
        }
        Storage.fruitStorage.put(fruit, difference);
    }

    @Override
    public void updateStorage(String fruit, int quantity) {
        if (!Storage.fruitStorage.containsKey(fruit)) {
            Storage.fruitStorage.put(fruit, quantity);
        }
        Integer currentQuantity = Storage.fruitStorage.get(fruit);
        Storage.fruitStorage.put(fruit, quantity + currentQuantity);
    }

    @Override
    public Map<String, Integer> getMapHandler() {
        return Storage.fruitStorage;
    }
}
