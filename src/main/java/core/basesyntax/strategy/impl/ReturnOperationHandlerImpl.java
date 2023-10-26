package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public int count(FruitTransaction fruitTransaction) {
        int quantity = fruitTransaction.getQuantity();

        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be less then zero: " + quantity);
        }

        return quantity;
    }
}
