package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandlers {
    void handleTransaction(FruitTransaction transaction);
}
