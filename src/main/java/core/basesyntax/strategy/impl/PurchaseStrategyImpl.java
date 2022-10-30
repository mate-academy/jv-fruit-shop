package core.basesyntax.strategy.impl;

import core.basesyntax.dao.impl.Storage;
import core.basesyntax.strategy.PurchaseStrategy;

public class PurchaseStrategyImpl implements PurchaseStrategy {
    @Override
    public void action(String fruit, Integer quantity) {
        if (existFruit(fruit)) {
            Storage.fruits.put(fruit, -quantity);
        } else {
            Storage.fruits.replace(fruit, Storage.fruits.get(fruit) - quantity);
        }
    }
}
