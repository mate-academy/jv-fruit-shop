package core.basesyntax.dao.impl;

import static core.basesyntax.db.Storage.fruitStorage;

import core.basesyntax.dao.StorageDao;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    @Override
     public Map<String, Integer> getAll() {
        return fruitStorage;
    }

    @Override
    public int getQuantity(String fruit) {
        return fruitStorage.get(fruit);
    }
}
