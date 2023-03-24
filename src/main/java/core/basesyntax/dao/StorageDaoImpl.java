package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {

    @Override
    public Fruit add(Fruit fruit, int quantity) {
        Storage.getStorage().put(fruit, quantity);
        return fruit;
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        if (Storage.getStorage().containsKey(fruit)) {
            return Storage.getStorage().get(fruit);
        }
        return null;
    }

    @Override
    public int size() {
        return Storage.getStorage().size();
    }
}
