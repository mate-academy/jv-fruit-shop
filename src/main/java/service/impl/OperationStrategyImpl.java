package service.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationStrategy;
import strategy.TransactionHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
