package core.basesyntax.service.strategy;

import core.basesyntax.storage.Storage;

public class FruitBalance implements FruitOperations {
    @Override
    public void fruitActivity(String fruit, int capacity) {
        Storage.getFruits().put(fruit, capacity);
    }
}
