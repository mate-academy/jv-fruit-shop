package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getQuantity(Fruit fruit) {
        return Storage.getStorage().getOrDefault(fruit, 0);
    }

    @Override
    public void add(Fruit fruit, int qty) {
        Storage.getStorage().put(fruit, qty);
    }
}
