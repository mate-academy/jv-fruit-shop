package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    @Override
    public void executeTransactions(List<Transaction> transactions) {
        transactions.forEach(operationStrategy::executeOperation);
    }
}
