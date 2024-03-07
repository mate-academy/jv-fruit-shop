package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessor implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public FruitTransactionProcessor(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processAll(List<FruitTransaction> transactions) {
        if (transactions.isEmpty()) {
            throw new RuntimeException("No transactions to process. Transaction list is empty!");
        }
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(transaction.getOperation());
            operationHandler.performOperation(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
