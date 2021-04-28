package core.basesyntax.dao.strategy;

import core.basesyntax.db.Storage;

public class FruitPurchase implements FruitOperations {
    @Override
    public void fruitActivity(String fruit, int capacity) {
        Storage.getFruits().replace(fruit, Storage.getFruits().get(fruit) - capacity);
    }
}
