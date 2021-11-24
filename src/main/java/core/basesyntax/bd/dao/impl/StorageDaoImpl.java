package core.basesyntax.bd.dao.impl;

import core.basesyntax.bd.Storage;
import core.basesyntax.bd.dao.StorageDao;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public boolean add(Fruit fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
        return true;
    }

    @Override
    public boolean isFruitPresent(Fruit fruit) {
        return Storage.fruitStorage.containsKey(fruit);
    }

    @Override
    public Integer getFruitQuantity(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruitStorage;
    }
}
