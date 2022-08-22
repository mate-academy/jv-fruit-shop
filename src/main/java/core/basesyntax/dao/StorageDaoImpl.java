package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.put(fruit.getType(), fruit);
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruits.entrySet().stream()
                .filter(f -> f.getKey().equals(fruit))
                .map(f -> f.getValue())
                .findFirst()
                .get();
    }
}
