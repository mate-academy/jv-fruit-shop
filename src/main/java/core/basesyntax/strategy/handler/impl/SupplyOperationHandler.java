package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public int operate(int transaction, int oldValue) {
        return oldValue + transaction;
    }
}
