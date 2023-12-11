package core.basesyntax.strategy;

import core.basesyntax.operationHandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
