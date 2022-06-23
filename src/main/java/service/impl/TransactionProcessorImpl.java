package service.impl;

import java.util.List;
import java.util.Map;
import model.Transaction;
import service.Strategy;
import service.TransactionProcessor;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Transaction.Operation, Strategy> operationStrategies;

    public TransactionProcessorImpl(Map<Transaction.Operation, Strategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public boolean process(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return false;
        }
        for (Transaction transaction : transactions) {
            Strategy strategy = pickStrategy(transaction.getOperation());
            if (strategy == null) {
                throw new RuntimeException("missing strategy in operationStrategies map");
            }
            strategy.updateStorage(transaction.getFruitName(), transaction.getQuantity());
        }
        return true;
    }

    private Strategy pickStrategy(Transaction.Operation operation) {
        if (operationStrategies == null) {
            throw new RuntimeException("Map operationStrategies not provided");
        }
        return operationStrategies.get(operation);
    }
}
