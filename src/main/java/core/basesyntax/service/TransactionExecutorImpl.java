package core.basesyntax.service;

import core.basesyntax.interfaces.TransactionExecutor;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationStrategy;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final OperationStrategy strategy;

    public TransactionExecutorImpl(
            OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void transactionExecute(FruitTransaction transaction) {
        strategy.get(transaction);
    }
}
