package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private static final TransactionStrategy strategy = new TransactionStrategy();

    @Override
    public void handle(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = strategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }
    }
}
