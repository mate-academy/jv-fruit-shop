package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionExecutorImpl implements TransactionExecutor {
    private OperationStrategy operationStrategy;

    public TransactionExecutorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.get(fruitTransaction.getOperation()).process(fruitTransaction);
        }
    }
}
