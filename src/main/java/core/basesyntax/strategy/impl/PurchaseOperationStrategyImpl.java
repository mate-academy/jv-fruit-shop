package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseOperationStrategyImpl implements OperationStrategy {
    private static final String NEGATIVE_BALANCE_ERR = "Negative balance. Not enough in stock.";

    @Override
    public void performOperation(FruitTransaction transaction) {
        Integer currentValue = Storage.getFruitStorage().get(transaction.getFruit());
        Integer newValue = currentValue - transaction.getQuantity();

        if (newValue < 0) {
            throw new RuntimeException(NEGATIVE_BALANCE_ERR);
        }

        Storage.getFruitStorage().put(transaction.getFruit(), newValue);
    }
}
