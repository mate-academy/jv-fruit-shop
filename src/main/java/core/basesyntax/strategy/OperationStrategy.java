package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
