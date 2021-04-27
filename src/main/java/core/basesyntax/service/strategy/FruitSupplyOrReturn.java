package core.basesyntax.service.strategy;

import core.basesyntax.storage.Storage;

public class FruitSupplyOrReturn implements FruitOperations {
    @Override
    public void fruitActivity(String fruit, int capacity) {
        Storage.getFruits().replace(fruit, Storage.getFruits().get(fruit) + capacity);
    }
}
