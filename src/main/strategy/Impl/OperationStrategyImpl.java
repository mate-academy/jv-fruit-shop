package main.strategy.Impl;

import main.model.ProductTransaction;
import main.service.Operation.OperationHandler;
import main.strategy.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy  {
    private Map<ProductTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<ProductTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(ProductTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
