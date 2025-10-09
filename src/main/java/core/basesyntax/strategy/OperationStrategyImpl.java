package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new RuntimeException("Handlers map cannot be null");
        }
        for (Map.Entry<FruitTransaction.Operation, OperationHandler> entry : handlers.entrySet()) {
            if (entry.getKey() == null) {
                throw new RuntimeException("Operation key cannot be null");
            }
            if (entry.getValue() == null) {
                throw new RuntimeException("Handler for operation "
                        + entry.getKey() + " cannot be null");
            }
        }
        this.handlers = new HashMap<>(handlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation cannot be null");
        }

        OperationHandler handler = handlers.get(operation);

        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + operation);
        }

        return handler;
    }
}
