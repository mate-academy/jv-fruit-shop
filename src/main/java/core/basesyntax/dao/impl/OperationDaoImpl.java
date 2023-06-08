package core.basesyntax.dao.impl;

import core.basesyntax.dao.OperationDao;
import core.basesyntax.db.Storage;

public class OperationDaoImpl implements OperationDao {
    @Override
    public void put(String key, Integer value) {
        Storage.getDb().put(key, value);
    }

    @Override
    public Integer get(String key) {
        return Storage.getDb().get(key);
    }

}
