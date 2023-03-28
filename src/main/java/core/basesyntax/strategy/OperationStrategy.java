package core.basesyntax.strategy;

import core.basesyntax.service.operationHandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(String operation);
}
