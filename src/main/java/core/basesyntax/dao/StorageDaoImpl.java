package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.put(fruit.getName(), fruit);
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruits.get(fruit);
    }
}
