package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.IOperationStrategy;
import core.basesyntax.service.operations.strategy.IOperationHandler;
import java.util.Map;

public class OperationStrategy implements IOperationStrategy {
    private final Map<Operation, IOperationHandler> operationHandlerMap;

    public OperationStrategy(Map<Operation, IOperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public IOperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
