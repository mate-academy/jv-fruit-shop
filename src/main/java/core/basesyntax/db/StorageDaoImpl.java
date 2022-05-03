package core.basesyntax.db;

import core.basesyntax.models.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {

    public void add(Fruit fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }

    public Integer get(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
