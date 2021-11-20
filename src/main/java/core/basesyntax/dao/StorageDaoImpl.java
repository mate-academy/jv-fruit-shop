package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StorageDaoImpl implements StorageDao<String, Integer>{
    private Fruit fruitEn = Fruit.APPLE;

    @Override
    public Integer put(String key, Integer value) {
        return Storage.fruitStorage.put(key, value);
    }

    @Override
    public Integer update(String fruit, Integer value) {
        return Storage.fruitStorage.replace(fruit, value);
    }

    @Override
    public List<Map.Entry<String, Integer>> get() {
        return new LinkedList<>(Storage.fruitStorage.entrySet());
    }

    @Override
    public Integer getCurrentQuantity(String fruit) {
       return Storage.fruitStorage.get(fruit);
    }
}
