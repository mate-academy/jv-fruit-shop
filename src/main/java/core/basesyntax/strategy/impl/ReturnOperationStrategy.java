package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnOperationStrategy implements OperationStrategy {
    @Override
    public void calculate(FruitTransaction transaction) {
        Storage.fruits.compute(transaction.getFruit(),
                (k, v) -> (v == null) ? 1 : v + transaction.getQuantity());
    }
}
