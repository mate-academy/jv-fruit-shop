package strategy.impl;

import strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public int apply(int quantity) {
        return quantity;
    }
}
