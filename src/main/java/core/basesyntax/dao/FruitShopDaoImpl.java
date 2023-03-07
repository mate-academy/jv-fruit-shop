package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public Map<Fruit, Integer> getRecords() {
        return Storage.storage;
    }

    @Override
    public void setRecords(Map<Fruit, Integer> dataMap) {
        Storage.storage.putAll(dataMap);
    }

    @Override
    public int getDbSize() {
        return Storage.storage.size();
    }
}
