package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Fruit add(Fruit fruit) {
        Storage.fruits.add(fruit);
        return fruit;
    }

    @Override
    public Fruit get(String name) {
        for (Fruit fruit: Storage.fruits) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits;
    }
}
