package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurposeStrategyOperationImpl implements OperationHandler {
    @Override
    public int getOperation(int amount) {
        return -amount;
    }
}
