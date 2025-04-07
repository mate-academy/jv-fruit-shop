package core.basesyntax.service;

import core.basesyntax.service.operationhandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
