package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerBalanceImpl implements OperationHandler {
    @Override
    public int calculateQuantity(int quantityBefore, int balance) {
        if (quantityBefore != 0) {
            throw new RuntimeException("QuantityBefore must be 0, but ii is "
                    + quantityBefore);
        }
        if (balance < 0) {
            throw new RuntimeException("Balance quantity must be over or equal 0, but it is "
                    + balance);
        }
        return balance;
    }
}
