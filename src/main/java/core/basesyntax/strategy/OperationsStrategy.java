package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import java.util.Map;

public class OperationsStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationsStrategy(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void performTransaction(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = handlers.get(fruitTransaction.getOperation());
        operationHandler.performOperation(fruitTransaction);
    }
}
