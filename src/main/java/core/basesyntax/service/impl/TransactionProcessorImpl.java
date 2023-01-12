package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy operationStrategy;

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy
                .getHandlerByOperation(transaction.getOperation()).apply(transaction));
    }
}
