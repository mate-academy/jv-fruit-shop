package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;
import core.basesyntax.model.FruitTransaction;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void addTransaction(FruitTransaction transaction) {
        String key = transaction.getFruit();
        int value = transaction.getQuantity();
        if (FruitStorage.storage.containsKey(key)) {
            FruitStorage.storage.put(key, FruitStorage.storage.get(key) + value);
        } else {
            FruitStorage.storage.put(key, value);
        }
    }

    @Override
    public Map<String, Integer> getData() {
        return FruitStorage.storage;
    }
}
