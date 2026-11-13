package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new IllegalArgumentException("Handlers cannot be null");
        }
        this.handlers = Map.copyOf(handlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        OperationHandler handler = handlers.get(operation);

        if (handler == null) {
            throw new IllegalArgumentException(
                    "No handler registered for operation: " + operation);
        }

        return handler;
    }
}
