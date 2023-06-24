package service;

import java.util.Map;
import model.FruitTransaction;
import service.transaction.TransactionHandler;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
                                TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
