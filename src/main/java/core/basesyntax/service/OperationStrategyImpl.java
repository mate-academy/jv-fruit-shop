package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> handlers;

    public OperationStrategyImpl(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return handlers.get(operation.getOperation());
    }
}
