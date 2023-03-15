package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return amount;
    }
}
