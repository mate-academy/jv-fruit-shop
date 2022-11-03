package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public int apply(int balance, int amount) {
        return balance - amount;
    }
}
