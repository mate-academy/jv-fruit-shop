package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionStrategy;

import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {

    private final TransactionStrategy strategy;

    public TransactionHandlerImpl(TransactionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void handle(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
    }
}
