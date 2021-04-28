package core.basesyntax.dao.strategy;

import core.basesyntax.db.Storage;

public class FruitBalance implements FruitOperations {
    @Override
    public void fruitActivity(String fruit, int capacity) {
        Storage.getFruits().put(fruit, capacity);
    }
}
