package service;

import java.util.Map;
import model.Operation;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation.Type operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Invalid operation");
        }
        return operationHandlerMap.get(operation);
    }
}
