package service.impl;

import java.util.Map;
import model.FruitTransaction;
import service.TransactionStrategy;
import service.activities.TransactionHandler;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            TransactionHandler> activitiesHandlerMap) {
        this.transactionHandlerMap = activitiesHandlerMap;
    }

    @Override
    public TransactionHandler getHandler(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
