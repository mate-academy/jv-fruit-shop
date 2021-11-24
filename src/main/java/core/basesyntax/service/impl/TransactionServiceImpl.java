package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean applyTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            operationStrategy
                    .get(transaction.getOperation())
                    .apply(transaction);
        }
        return true;
    }
}
