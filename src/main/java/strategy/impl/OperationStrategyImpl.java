package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }

    @Override
    public int applyOperation(FruitTransaction transaction, int currentAmount) {
        OperationHandler handler = operationHandlerMap.get(transaction.getOperation());
        if (handler == null) {
            throw new IllegalArgumentException("Unknown operation: " + transaction.getOperation());
        }
        return handler.getOperation(transaction, currentAmount);
    }
}
