package core.basesyntax.transaction.impl;

import core.basesyntax.transaction.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
