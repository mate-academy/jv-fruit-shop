package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Integer getQuantity(Fruit fruit) {
        return FruitStorage.storage.get(fruit);
    }

    @Override
    public Integer put(Fruit key, Integer value) {
        return FruitStorage.storage.put(key, value);
    }
}
