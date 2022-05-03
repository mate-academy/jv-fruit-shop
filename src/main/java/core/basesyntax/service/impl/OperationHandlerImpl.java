package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationHandlerImpl implements TransactionHandler {
    private final OperationStrategy operationStrategy;

    public OperationHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void execute(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operation = operationStrategy.get(transaction.getOperation());
            operation.handle(transaction);
        }
    }
}
