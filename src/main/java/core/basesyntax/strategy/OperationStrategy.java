package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> handlers;

    public OperationStrategy(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler getByOperation(String operation) {
        return handlers.get(operation);
    }
}
