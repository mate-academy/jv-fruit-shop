package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void set(Fruit fruit, Integer amount) {
        Storage.data.put(fruit, amount);
    }

    @Override
    public void add(Fruit fruit, Integer amount) {
        Integer storedAmount = Storage.data.get(fruit);
        Storage.data.put(fruit, storedAmount + amount);
    }

    @Override
    public void reduce(Fruit fruit, Integer amount) {
        Integer storedAmount = Storage.data.get(fruit);
        Storage.data.put(fruit, storedAmount - amount);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.data.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.data;
    }
}
