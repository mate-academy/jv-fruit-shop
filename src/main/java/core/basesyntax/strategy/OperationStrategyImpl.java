package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + operation);
        }
        return handler;
    }
}
