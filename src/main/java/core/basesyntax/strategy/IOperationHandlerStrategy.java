package core.basesyntax.strategy;

import core.basesyntax.service.operations.OperationHandler;

public interface IOperationHandlerStrategy {
    OperationHandler chooseOperation(String operation);
}
