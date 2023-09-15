package service.impl;

import java.util.List;
import model.Transaction;
import service.TransactionProcessor;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<Transaction> transactionsList) {
        for (Transaction transaction : transactionsList) {
            OperationHandler operationHandler = operationStrategy
                    .get(transaction.getFruitOperationType());
            operationHandler.doTransaction(transaction.getFruitName(), transaction.getFruitValue());
        }
    }
}
