package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void decreaseFruitQuantity(Fruit fruit, Integer quantity) {
        if (Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
        } else {
            Storage.storage.put(fruit, -quantity);
        }
    }

    @Override
    public void increaseFruitQuantity(Fruit fruit, Integer quantity) {
        if (Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) + quantity);
        } else {
            Storage.storage.put(fruit, quantity);
        }
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return new HashMap<>(Storage.storage);
    }

}
