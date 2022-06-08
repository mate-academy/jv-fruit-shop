package core.strategy;

import core.strategy.handlers.OperationHandler;

public interface OperationHandlerStrategy {
    OperationHandler get(String operation);
}
