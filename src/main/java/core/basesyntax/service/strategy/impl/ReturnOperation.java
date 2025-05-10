package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public int getOperationType(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Invalid data. Return quantity can't be negative: "
                    + quantity);
        }
        return quantity;
    }
}
