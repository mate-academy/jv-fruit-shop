package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerImplBalance implements OperationHandler {
    @Override
    public int apply(int balance, int quantity) {
        return balance + quantity;
    }
}
