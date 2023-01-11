package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class ReturnStrategyOperationImpl implements OperationHandler {
    @Override
    public int getOperation(int amount) {
        return amount;
    }
}
