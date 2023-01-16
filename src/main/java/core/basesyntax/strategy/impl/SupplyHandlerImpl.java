package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class SupplyHandlerImpl implements OperationHandler {
    @Override
    public int handle(int balance, int count) {
        return balance + count;
    }
}
