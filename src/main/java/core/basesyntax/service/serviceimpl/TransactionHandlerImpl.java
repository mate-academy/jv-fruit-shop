package core.basesyntax.service.serviceimpl;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.serviceimpl.operationhandlers.OperationHandler;
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
            operationHandler.handleOperation(fruitTransaction);
        }
    }
}
