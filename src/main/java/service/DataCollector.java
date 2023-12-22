package service;

import java.util.List;
import model.FruitTransaction;
import strategy.TransactionStrategy;

public class DataCollector {
    private final TransactionStrategy strategy;

    public DataCollector(TransactionStrategy transactionStrategy) {
        this.strategy = transactionStrategy;
    }

    public void applyTransactionsToDatabase(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.getTransactionService(transaction.getOperation())
                    .applyTransaction(transaction);
        }
    }
}
