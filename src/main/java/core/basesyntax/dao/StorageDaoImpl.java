package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Integer get(String fruit) {
        return Storage.getCalculationMap().get(fruit);
    }

    @Override
    public void put(String fruit, Integer amount) {
        Storage.getCalculationMap().put(fruit, amount);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getCalculationMap();

    }
}
