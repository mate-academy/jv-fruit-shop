package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public Fruit add(Fruit fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
        return fruit;
    }

    @Override
    public boolean contains(Fruit fruit) {
        return Storage.storage.containsKey(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        Map<Fruit, Integer> newMap = new HashMap<>();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        return newMap;
    }
}
