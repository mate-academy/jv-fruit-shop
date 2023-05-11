package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionHandlerImpl implements FruitTransactionHandler {
    private final OperationStrategy operationStrategy;

    public FruitTransactionHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void handleFruitTransactions(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.operate(transaction);
        }
    }
}
