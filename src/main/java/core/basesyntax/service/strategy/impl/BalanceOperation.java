package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getOperationType(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Invalid data. Balance quantity can't be negative: "
                    + quantity);
        }
        return quantity;
    }
}
