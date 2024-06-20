package strategy.impl;

import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public int apply(int quantity) {
        if (quantity >= 0) {
            return quantity;
        }
        throw new RuntimeException("alance can't be negative, in file balance = " + quantity);
    }
}
