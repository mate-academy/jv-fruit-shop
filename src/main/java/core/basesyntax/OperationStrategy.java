package core.basesyntax;

import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategy(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void processOperation(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = handlers.get(fruitTransaction.getOperation());
        operationHandler.handle(fruitTransaction);
    }
}
