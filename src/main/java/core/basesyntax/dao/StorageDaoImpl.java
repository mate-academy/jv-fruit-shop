package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, Integer quantity) {
        if (Storage.fruitStorage.get(fruit) == null) {
            Storage.fruitStorage.put(fruit, quantity);
        } else {
            Storage.fruitStorage.replace(fruit, get(fruit) + quantity);
        }
    }

    @Override
    public void remove(Fruit fruit, Integer quantity) {
        Storage.fruitStorage.replace(fruit, get(fruit) - quantity);
    }

    @Override
    public int get(Fruit fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.fruitStorage.entrySet();
    }
}
