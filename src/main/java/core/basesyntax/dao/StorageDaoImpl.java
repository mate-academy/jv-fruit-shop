package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    public List<Map.Entry<Fruit, Integer>> getStorageInfo() {
        return new LinkedList<>(Storage.fruitStorage.entrySet());
    }

    @Override
    public Integer getCurrentQuantity(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }
}
