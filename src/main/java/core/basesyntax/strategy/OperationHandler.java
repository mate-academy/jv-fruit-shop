package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int getOperation(int amount);
}
