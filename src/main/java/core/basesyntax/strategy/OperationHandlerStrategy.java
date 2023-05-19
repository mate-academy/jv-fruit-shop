package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;

public interface OperationHandlerStrategy {
    public OperationHandler getOperationService(String operation);
}
