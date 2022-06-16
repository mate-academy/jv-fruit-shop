package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    Map<String, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<String, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }
    @Override
    public OperationHandler getOperationHandler(String operation) {
        return operationHandlers.get(operation);
    }
}
