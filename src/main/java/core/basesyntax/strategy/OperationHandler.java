package core.basesyntax.strategy;

import core.basesyntax.storage.FruitTransaction;

public interface OperationHandler {
    void handleTransaction(FruitTransaction transaction);
}
