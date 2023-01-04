package service.impl;

import java.util.Map;
import model.Operation;
import service.OperationHandle;
import service.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandle> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandle> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandle get(Operation type) {
        return operationHandlerMap.get(type);
    }
}
