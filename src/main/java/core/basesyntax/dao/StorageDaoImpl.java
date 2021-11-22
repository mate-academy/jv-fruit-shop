package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.LinkedList;
import java.util.List;

public class StorageDaoImpl implements StorageDao<Fruit> {

    @Override
    public boolean put(Fruit fruit) {
        return Storage.fruitStorage.add(fruit);
    }

    @Override
    public List<Fruit> getStorageInfo() {
        return new LinkedList<>(Storage.fruitStorage);
    }
}
