package core.basesyntax.dao.impl;

import core.basesyntax.dao.OperationDao;
import core.basesyntax.db.StorageImpl;

public class OperationDaoImpl implements OperationDao {
    @Override
    public void put(String key, Integer value) {
        StorageImpl.fruits.put(key, value);
    }

    @Override
    public Integer get(String key) {
        return StorageImpl.fruits.get(key) == null ? 0 : StorageImpl.fruits.get(key);
    }
}
