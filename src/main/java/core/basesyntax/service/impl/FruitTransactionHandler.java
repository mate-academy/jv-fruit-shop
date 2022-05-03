package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionHandler implements TransactionHandler {
    private final OperationStrategy operationStrategy;

    public FruitTransactionHandler(OperationStrategy operationStrategy) {
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
