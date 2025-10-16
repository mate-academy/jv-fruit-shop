package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;
import java.util.Objects;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers
    ) {
        this.operationHandlers = Objects.requireNonNull(operationHandlers,
                "operationHandlers map must not be null");
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        Objects.requireNonNull(operation, "operation must not be null");
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new IllegalStateException("No handler registered"
                    + " for operation: " + operation);
        }
        return handler;
    }
}
