package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Integer getValue(Fruit key) {
        return FruitStorage.storage.get(key);
    }

    @Override
    public Integer put(Fruit key, Integer value) {
        return FruitStorage.storage.put(key, value);
    }
}
