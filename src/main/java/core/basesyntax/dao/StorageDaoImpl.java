package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.LinkedList;
import java.util.List;

public class StorageDaoImpl implements StorageDao<Fruit, Integer> {

    @Override
    public Integer put(Fruit key, Integer value) {
        return Storage.fruitStorage.put(key, value);
    }

    @Override
    public Integer update(Fruit fruit, Integer value) {
        return Storage.fruitStorage.replace(fruit, value);
    }

    @Override
    public List<Fruit> getStorageInfo() {
        return new LinkedList<>(Storage.fruitStorage.keySet());
    }

    @Override
    public Integer getCurrentQuantity(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }
}
