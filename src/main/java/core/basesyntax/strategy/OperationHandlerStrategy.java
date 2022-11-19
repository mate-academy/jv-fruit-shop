package core.basesyntax.strategy;

import core.basesyntax.service.operations.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler chooseOperation(String operation);
}
