package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(Fruit fruit, Integer quantity) {
        if (Storage.storage.putIfAbsent(fruit, quantity) != null) {
            Storage.storage.compute(fruit, (key, val) -> val == null ? quantity : val + quantity);
        }
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getEntries() {
        return Storage.storage.entrySet();
    }
}
