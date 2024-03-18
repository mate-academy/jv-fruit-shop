package core.basesyntax.service.impl;

import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionProcessor;

public class FruitTransactionProcessor implements TransactionProcessor<FruitTransaction> {
    private OperationStrategy<FruitTransaction> strategy;

    public FruitTransactionProcessor(OperationStrategy<FruitTransaction> strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(FruitTransaction transaction) {
        OperationHandler<FruitTransaction> operationStrategy = strategy.get(transaction);
        if (operationStrategy != null) {
            operationStrategy.handle(transaction);
        } else {
            throw new RuntimeException("Unknown operation type: "
                    + transaction.getTransactionType());
        }
    }
}
