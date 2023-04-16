package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
