package service;

import java.util.Map;
import model.FruitTransaction;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.OperationType,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationStrategy(FruitTransaction.OperationType type) {
        return operationHandlerMap.get(type);
    }
}
