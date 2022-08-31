package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void addData(String fruit, int quantity) {
        if (FruitStorage.storage.containsKey(fruit)) {
            FruitStorage.storage.put(fruit, FruitStorage.storage.get(fruit) + quantity);
        } else {
            FruitStorage.storage.put(fruit, quantity);
        }
    }

    @Override
    public Set<Map.Entry<String, Integer>> getData() {
        return FruitStorage.storage.entrySet();
    }
}
