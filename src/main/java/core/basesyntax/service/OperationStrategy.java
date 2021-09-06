package core.basesyntax.service;

import core.basesyntax.service.operationHandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(String operation);
}
