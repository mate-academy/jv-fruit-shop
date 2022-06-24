package service.impl;

import java.util.List;
import java.util.Map;
import model.Transaction;
import service.Handler;
import service.TransactionProcessor;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Transaction.Operation, Handler> operationStrategies;

    public TransactionProcessorImpl(Map<Transaction.Operation, Handler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public boolean process(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty()) {
            return false;
        }
        for (Transaction transaction : transactions) {
            Handler strategy = pickStrategy(transaction.getOperation());
            if (strategy == null) {
                throw new RuntimeException("missing strategy in operationStrategies map");
            }
            strategy.updateStorage(transaction.getFruitName(), transaction.getQuantity());
        }
        return true;
    }

    private Handler pickStrategy(Transaction.Operation operation) {
        return operationStrategies.get(operation);
    }
}
