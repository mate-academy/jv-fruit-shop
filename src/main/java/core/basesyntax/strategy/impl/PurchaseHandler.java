package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int getFruitAmount(int amount) {
        return -amount;
    }

    @Override
    public FruitTransaction.Operation getType() {
        return FruitTransaction.Operation.PURCHASE;
    }
}
