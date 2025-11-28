package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public int handle(FruitTransaction transaction, int currentBalance) {
        return transaction.getQuantity() + currentBalance;
    }
}
