package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyBalanceImpl implements OperationStrategy {
    @Override
    public int calculateQuantity(int quantityBefore, int currentQuantity) {
        throw new RuntimeException("In this case you should use "
                + "putPreviousPeriodQuantity() method");
    }

    @Override
    public int putPreviousPeriodQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity mustn't be less 0, but it is " + quantity);
        }
        return quantity;
    }
}
