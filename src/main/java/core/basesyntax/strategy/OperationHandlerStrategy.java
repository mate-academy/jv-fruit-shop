package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationHandlerStrategy(
            Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
