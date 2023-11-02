package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public Integer get(FruitTransaction transaction) {
        String key = transaction.getFruit();
        if (Storage.storage.containsKey(key)) {
            return Storage.storage.get(key);
        }
        throw new RuntimeException("No such fruit in the storage");
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storage;
    }
}
