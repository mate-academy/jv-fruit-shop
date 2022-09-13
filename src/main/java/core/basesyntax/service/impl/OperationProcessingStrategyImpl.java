package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationProcessingStrategy;
import core.basesyntax.strategy.TransactionsHandler;
import java.util.Map;

public class OperationProcessingStrategyImpl implements OperationProcessingStrategy {
    private final Map<Transaction.Operation, TransactionsHandler> transactionHandlingMap;

    public OperationProcessingStrategyImpl(
            Map<Transaction.Operation, TransactionsHandler> transactionHandlingMap) {
        this.transactionHandlingMap = transactionHandlingMap;
    }

    @Override
    public TransactionsHandler get(Transaction.Operation transaction) {
        return transactionHandlingMap.get(transaction);
    }
}
