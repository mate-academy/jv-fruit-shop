package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationProcessingStrategy;
import core.basesyntax.strategy.TransactionsHandling;
import java.util.Map;

public class OperationProcessingStrategyImpl implements OperationProcessingStrategy {
    private final Map<Transaction.Operation, TransactionsHandling> transactionHandlingMap;

    public OperationProcessingStrategyImpl(
            Map<Transaction.Operation, TransactionsHandling> transactionHandlingMap) {
        this.transactionHandlingMap = transactionHandlingMap;
    }

    @Override
    public TransactionsHandling get(Transaction.Operation transaction) {
        return transactionHandlingMap.get(transaction);
    }
}
