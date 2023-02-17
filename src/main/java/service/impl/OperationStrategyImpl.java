package service.impl;

import java.util.Map;
import model.Operation;
import service.OperationHandler;
import service.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation type) {
        return operationHandlerMap.get(type);
    }
}
