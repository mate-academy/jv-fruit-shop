package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void save(Fruit fruit, Integer amount) {
        Storage.leftovers.put(fruit, amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.leftovers.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.leftovers;
    }
}
