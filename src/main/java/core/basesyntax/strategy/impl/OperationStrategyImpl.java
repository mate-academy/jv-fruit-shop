package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
