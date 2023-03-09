package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final OperationStrategy strategy;

    public TransactionHandlerImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void handleTransactions(List<Transaction> transactionList) {
        transactionList.forEach(transaction ->
                strategy.getOperationHandler(transaction.getOperation())
                        .handleOperation(transaction));
    }
}
