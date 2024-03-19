package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class ProductDaoImpl implements ProductDao {
    @Override
    public int add(String key, int newValue) {
        Storage.fruitStorage.put(key, newValue);
        return Storage.fruitStorage.get(key);
    }

    @Override
    public Integer getValue(String key) {
        return Storage.fruitStorage.get(key);
    }
}
