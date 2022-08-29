package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageFruits;
import core.basesyntax.strategy.Strategy;

public class SupplyStrategy implements Strategy {
    @Override
    public void makeOperation(String fruit, int value) {
        Integer previousValue = StorageFruits.fruits.get(fruit);
        StorageFruits.fruits.put(fruit, previousValue + value);
    }
}
