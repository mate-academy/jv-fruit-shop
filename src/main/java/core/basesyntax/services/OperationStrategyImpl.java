package core.basesyntax.services;

import core.basesyntax.operationhanlerservices.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(OperationType operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return operationHandlerMap.get(operation);
    }
}
