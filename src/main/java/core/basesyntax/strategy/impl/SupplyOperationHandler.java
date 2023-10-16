package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int operate(Integer oldAmount, Integer newAmount) {
        return oldAmount + newAmount;
    }
}
