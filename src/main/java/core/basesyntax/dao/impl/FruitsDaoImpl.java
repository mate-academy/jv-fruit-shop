package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public Map<String, Integer> storageAccess() {
        return Storage.getFruits();
    }
}
