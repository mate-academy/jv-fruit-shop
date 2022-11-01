package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;

public class OperationHandlerBalanceImpl implements OperationHandler {
    @Override
    public int operate(int balance, int count) {
        return balance + count;
    }
}
