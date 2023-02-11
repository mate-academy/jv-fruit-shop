package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerImplReturnImpl implements OperationHandler {
    @Override
    public int apply(int balance, int count) {
        return balance + count;
    }
}
