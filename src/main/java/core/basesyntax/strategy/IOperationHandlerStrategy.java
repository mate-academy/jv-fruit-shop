package core.basesyntax.strategy;

import core.basesyntax.service.operations.IOperationHandler;

public interface IOperationHandlerStrategy {
    IOperationHandler chooseOperation(String operation);
}
