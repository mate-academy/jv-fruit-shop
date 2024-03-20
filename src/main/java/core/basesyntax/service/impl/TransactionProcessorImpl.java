package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactionList(
            List<FruitTransaction> transactionList
    ) {
        for (FruitTransaction transaction : transactionList) {
            OperationHandler handler = operationStrategy.getHandlerFor(transaction.operation());
            handler.handle(transaction);
        }
    }
}
