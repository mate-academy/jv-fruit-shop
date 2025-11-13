package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> operationHandlers;

    public OperationStrategy(Map<Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler get(Operation operation) {
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new RuntimeException("Unknown type of operation: " + operation);
        }
        return handler;
    }
}
