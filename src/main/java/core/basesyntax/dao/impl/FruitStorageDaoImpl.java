package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Set;

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
    public Set<Map.Entry<String, Integer>> getData() {
        return FruitStorage.storage.entrySet();
    }
}
