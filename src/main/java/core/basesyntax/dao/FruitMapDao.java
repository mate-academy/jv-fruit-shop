package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitMapDao implements FruitStorageDao {
    private static final int INITIAL_QUANTITY = 0;

    @Override
    public void update(Fruit fruit, int quantity) {
        if (!Storage.map.containsKey(fruit)) {
            throw new RuntimeException("Can't find fruit for update");
        }
        Storage.map.put(fruit, quantity);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.map;
    }

    @Override
    public int getQuantity(Fruit fruit) {
        Storage.map.putIfAbsent(fruit, INITIAL_QUANTITY);
        return Storage.map.get(fruit);
    }
}

