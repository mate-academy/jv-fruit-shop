package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

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
    public int getQuantity(Fruit fruit) {
        checkFruit(fruit);
        return Storage.map.get(fruit);
    }

    private boolean checkFruit(Fruit fruit) {
        if (Storage.map.containsKey(fruit)) {
            return false;
        }
        Storage.map.put(fruit, INITIAL_QUANTITY);
        return true;
    }
}

