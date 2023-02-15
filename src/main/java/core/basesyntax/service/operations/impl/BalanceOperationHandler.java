package core.basesyntax.service.operations.impl;

import core.basesyntax.service.operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int operate(int balance, int quantity) {
        return quantity;
    }
}
