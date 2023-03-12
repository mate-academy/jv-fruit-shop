package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    StoreActivities getHandler(FruitTransaction.Operation operation);
}
