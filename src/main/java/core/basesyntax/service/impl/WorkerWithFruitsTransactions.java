package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.WorkerWithTransactions;
import core.basesyntax.strategy.OperationStrategy;

public class WorkerWithFruitsTransactions implements WorkerWithTransactions {
    private final OperationStrategy operationStrategy;

    public WorkerWithFruitsTransactions(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void completeTransaction(Transaction transaction) {
        operationStrategy.getOperationHandler(transaction.getOperationType())
                .processData(transaction.getName(), transaction.getQuantity());
    }
}
