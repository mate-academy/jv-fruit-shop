package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> handlers;

    public OperationStrategy(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void handleOperation(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = handlers.get(fruitTransaction.getOperation());
        operationHandler.handle(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
