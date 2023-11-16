package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.List;

public class TransactionPerformerImpl implements TransactionPerformer {
    private final OperationStrategy operationStrategy;

    public TransactionPerformerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void performTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.handle(transaction);
        }
    }
}
