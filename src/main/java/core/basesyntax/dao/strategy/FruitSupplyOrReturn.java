package core.basesyntax.dao.strategy;

import core.basesyntax.db.Storage;

public class FruitSupplyOrReturn implements FruitOperations {
    @Override
    public void fruitActivity(String fruit, int capacity) {
        Storage.getFruits().replace(fruit, Storage.getFruits().get(fruit) + capacity);
    }
}
