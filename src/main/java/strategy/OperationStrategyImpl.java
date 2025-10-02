package strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new IllegalArgumentException("Handlers map cannot be null");
        }
        this.handlers = new HashMap<>(handlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler for operation: " + operation);
        }
        return handler;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getHandlers() {
        return Collections.unmodifiableMap(handlers);
    }
}
