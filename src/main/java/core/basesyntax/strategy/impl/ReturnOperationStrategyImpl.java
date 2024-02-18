package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnOperationStrategyImpl implements OperationStrategy {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Integer currentValue = Storage.getFruitStorage().get(transaction.getFruit());
        Integer newValue = currentValue + transaction.getQuantity();

        Storage.getFruitStorage().put(transaction.getFruit(), newValue);
    }
}
