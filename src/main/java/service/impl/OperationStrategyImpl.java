package service.impl;

import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import service.OperationStrategy;
import service.operation.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction fruitTransaction) {
        return operationHandlerMap.get(
                OperationType.getOperation(fruitTransaction.getOperation().trim()));
    }
}
