package service.impl;

import model.FruitTransaction;
import operation.OperationHandler;
import service.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
