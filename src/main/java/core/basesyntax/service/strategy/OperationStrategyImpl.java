package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler found for operation :" + operation);
        }
        return handler;
    }
}
