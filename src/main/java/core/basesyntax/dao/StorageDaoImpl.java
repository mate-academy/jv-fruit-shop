package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int add(Fruit fruit, int quantity) {
        return Storage.storage.put(fruit, quantity);
    }

    @Override
    public int update(Fruit fruit, int quantity) {
        int currentQuantity = get(fruit);
        return Storage.storage.put(fruit, currentQuantity + quantity);
    }

    @Override
    public int get(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
