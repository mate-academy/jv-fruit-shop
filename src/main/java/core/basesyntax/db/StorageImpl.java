package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StorageImpl implements Storage {
    private Map<Fruit, Integer> storage;

    public StorageImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(Fruit fruit, Integer quantity) {
        Integer fruitAmount = storage.get(fruit);
        storage.put(fruit,
                fruitAmount == null ? quantity : fruitAmount + quantity);
    }

    @Override
    public void remove(Fruit fruit, Integer quantity) {
        Integer fruitAmount = storage.get(fruit);
        if (fruitAmount < quantity) {
            throw new RuntimeException("Can't remove fruit" + fruit);
        }
        storage.put(fruit,
                fruitAmount == null ? quantity : fruitAmount - quantity);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAllFruits() {
        return storage.entrySet();
    }
}
