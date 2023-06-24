package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandleImpl implements OperationHandler {
    @Override
    public int apply(int balance, int count) {
        return balance + count;
    }
}
