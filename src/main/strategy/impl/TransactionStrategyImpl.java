package main.strategy.impl;

import main.model.Transaction;
import main.service.transaction.TransactionHandler;
import main.strategy.TransactionStrategy;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<Transaction, TransactionHandler> transactionHandlerMap;

    public TransactionStrategyImpl(Map<Transaction, TransactionHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public TransactionHandler get(Transaction transaction) {
        return transactionHandlerMap.get(transaction);
    }
}
