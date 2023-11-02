package core.basesyntax.transactions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategy(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void handler(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = handlers.get(fruitTransaction.getOperation());
        operationHandler.processTransaction(fruitTransaction);
    }
}
