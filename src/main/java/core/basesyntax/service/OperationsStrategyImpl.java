package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.Operation;
import java.util.Collections;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationsStrategyImpl(Map<Operation, OperationHandler> handlers) {
        if (handlers == null) {
            throw new FruitShopException("Handlers map is null");
        }
        this.handlers = Collections.unmodifiableMap(Map.copyOf(handlers));
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        if (operation == null) {
            throw new FruitShopException("Operation is null");
        }
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new FruitShopException("No handler found for operation: " + operation);
        }
        return handler;
    }
}
