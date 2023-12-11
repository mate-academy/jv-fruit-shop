package core.basesyntax;

import core.basesyntax.operationHandler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessor(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void processTransactions(List<FruitTransaction> transactions, FruitStore fruitStore) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handleOperation(fruitStore, transaction, transaction.getOperation());
        }
    }
}
