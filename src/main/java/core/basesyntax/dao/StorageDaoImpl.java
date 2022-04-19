package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void decreaseFruitQuantity(Fruit fruit, Integer quantity) {
        Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
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
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
