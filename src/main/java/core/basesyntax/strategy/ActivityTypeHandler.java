package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivityTypeHandler {
    FruitTransaction.Operation getActivityType();

    int getSumOfOperation(int quantity);
}
