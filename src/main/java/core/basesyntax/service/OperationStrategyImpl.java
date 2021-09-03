package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return operationHandlerMap.get(operation);
    }
}
