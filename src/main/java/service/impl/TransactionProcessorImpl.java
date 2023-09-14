package service.impl;

import java.util.List;
import model.Transaction;
import service.TransactionProcessor;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void createReport(List<Transaction> transactionsList,
                             OperationStrategy operationStrategy) {
        for (Transaction transaction : transactionsList) {
            OperationHandler operationHandler = operationStrategy
                    .get(transaction.getFruitOperationType());
            operationHandler.doTransaction(transaction.getFruitName(), transaction.getFruitValue());
        }
    }
}
