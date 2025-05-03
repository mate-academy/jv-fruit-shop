package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int makeOperation(FruitTransaction transaction, int storedAmount);
}
