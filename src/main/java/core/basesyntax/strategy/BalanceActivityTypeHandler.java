package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class BalanceActivityTypeHandler implements ActivityTypeHandler {
    @Override
    public FruitTransaction.Operation getActivityType() {
        return FruitTransaction.Operation.BALANCE;
    }

    @Override
    public int getSumOfOperation(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Fruit quantity cannot be negative");
        }
        return quantity;
    }
}
