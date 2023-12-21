package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.TransactionService;
import strategy.TransactionStrategy;

public class DataCollector {
    private final Map<FruitTransaction.Operation, TransactionService> operationMap;

    public DataCollector(Map<FruitTransaction.Operation, TransactionService> operationMap) {
        this.operationMap = operationMap;
    }

    public void applyTransactionsToDatabase(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            applyTransaction(transaction);
        }
    }

    private void applyTransaction(FruitTransaction transaction) {
        TransactionService transactionService = new TransactionStrategy(operationMap)
                .getTransactionService(transaction.getOperation());
        if (transactionService == null) {
            throw new RuntimeException("No implementation for operation: "
                    + transaction.getOperation());
        }
        transactionService.applyTransaction(transaction);
    }
}
