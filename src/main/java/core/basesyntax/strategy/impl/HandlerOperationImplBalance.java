package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.HandlerOperation;

public class HandlerOperationImplBalance implements HandlerOperation {
    @Override
    public int apply(int balance, int count) {
        return balance + count;
    }
}
