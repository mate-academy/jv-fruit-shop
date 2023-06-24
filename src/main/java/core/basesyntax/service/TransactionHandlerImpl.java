package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private TransactionStrategyImpl strategy;

    public TransactionHandlerImpl(TransactionStrategyImpl strategy) {
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
