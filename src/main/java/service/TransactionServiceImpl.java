package service;

import java.util.List;
import model.Transaction;
import service.operation.OperationHandler;
import service.operation.OperationStrategy;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy strategy;

    public TransactionServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void processTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperation(transaction);
            handler.proceed(transaction);
        }
    }
}
