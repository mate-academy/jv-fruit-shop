package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;
import java.util.Map;

public class TransactionStrategy implements Strategy {
    private Map<StorageTransaction.Operation, Transaction> transactions;

    public TransactionStrategy(Map<StorageTransaction.Operation, Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public Transaction getTransaction(StorageTransaction transaction) {
        return transactions.get(transaction.getOperation());
    }
}
