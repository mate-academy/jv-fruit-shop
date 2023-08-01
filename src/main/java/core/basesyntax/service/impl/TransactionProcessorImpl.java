package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final Map<Transaction.Operation, OperationStrategy> handlers;

    public TransactionProcessorImpl(Map<Transaction.Operation, OperationStrategy> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(Transaction transaction) {
        handlers.get(transaction.getOperation())
                .apply(transaction.getFruit(), transaction.getQuantity());
    }
}
