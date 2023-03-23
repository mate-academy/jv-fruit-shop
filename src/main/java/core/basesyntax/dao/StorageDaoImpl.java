package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Storage storage;

    @Override
    public Fruit add(Fruit fruit, int quantity) {
        storage.getStorage().put(fruit, quantity);
        return fruit;
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return storage.getStorage().get(fruit);
    }

    @Override
    public int size() {
        return storage.getStorage().size();
    }
}
