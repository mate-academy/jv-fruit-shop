package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void compute(Fruit fruit, Integer quantity) {
        Storage.storage.compute(fruit, (key, val) -> val == null ? quantity : val + quantity);
    }

    @Override
    public Integer getValue(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
