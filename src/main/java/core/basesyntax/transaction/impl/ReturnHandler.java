package core.basesyntax.transaction.impl;

import core.basesyntax.transaction.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
