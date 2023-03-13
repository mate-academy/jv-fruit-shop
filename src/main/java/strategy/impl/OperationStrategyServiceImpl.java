package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyServiceImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyServiceImpl(Map<FruitTransaction
            .Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operationType) {
        return operationHandlerMap.get(operationType);
    }
}
