package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int getFruitAmount(int amount);

    FruitTransaction.Operation getType();
}
