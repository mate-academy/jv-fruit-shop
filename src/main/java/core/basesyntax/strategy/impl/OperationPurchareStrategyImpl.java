package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class OperationPurchareStrategyImpl implements OperationStrategy {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int current = Storage.getStorage().getOrDefault(fruitTransaction.getFruit(), 0);
        if (current < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Current amount can't be less then removed");
        }
        Storage.getStorage().put(fruitTransaction.getFruit(),
                current - fruitTransaction.getQuantity());

    }
}
