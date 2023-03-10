package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final OperationStrategy operationStrategy;

    public TransactionExecutorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            operationStrategy.getHandler(transaction.getOperation()).toProcess(transaction);
        }
    }
}
