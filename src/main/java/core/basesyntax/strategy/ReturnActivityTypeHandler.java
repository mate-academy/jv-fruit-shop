package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class ReturnActivityTypeHandler implements ActivityTypeHandler {
    @Override
    public FruitTransaction.Operation getActivityType() {
        return FruitTransaction.Operation.RETURN;
    }

    @Override
    public int getSumOfOperation(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Fruit quantity cannot be negative");
        }
        return quantity;
    }
}
