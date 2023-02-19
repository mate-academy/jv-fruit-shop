package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addToStorage(Transaction transaction) {
        Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity());
    }

    @Override
    public void removeFromStorage(Transaction transaction) {
        Integer currentQuantity = Storage.fruitStorage.get(transaction.getFruitName());
        int difference = currentQuantity - transaction.getQuantity();
        if (difference < 0) {
            throw new RuntimeException(transaction.getFruitName() + " not enough at the storage");
        }
        Storage.fruitStorage.put(transaction.getFruitName(), difference);
    }

    @Override
    public void updateStorage(Transaction transaction) {
        if (!Storage.fruitStorage.containsKey(transaction.getFruitName())) {
            Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity());
        }
        Integer currentQuantity = Storage.fruitStorage.get(transaction.getFruitName());
        Storage.fruitStorage.put(transaction.getFruitName(), transaction.getQuantity()
                + currentQuantity);
    }

    @Override
    public Map<String, Integer> getMapHandler() {
        return Storage.fruitStorage;
    }
}
