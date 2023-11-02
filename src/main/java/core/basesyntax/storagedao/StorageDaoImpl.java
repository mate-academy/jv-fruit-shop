package core.basesyntax.storagedao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Map.Entry<Fruit, Integer> get(String name) {
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    public boolean isInStorage(String name) {
        return get(name) != null;
    }

    @Override
    public Map<Fruit, Integer> getALl() {
        return new HashMap<>(Storage.fruits);
    }
}
