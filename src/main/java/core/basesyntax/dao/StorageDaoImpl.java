package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Integer getAmount(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public void update(Fruit fruit, Integer amount) {
        Storage.storage.put(fruit,amount);
    }

    @Override
    public Set<Fruit> getAll() {
        return Storage.storage.keySet();
    }
}
