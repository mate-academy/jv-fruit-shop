package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategy(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void handleOperation(FruitTransaction fruitTransaction) {
        handlers.get(fruitTransaction.getOperation())
                .handle(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
