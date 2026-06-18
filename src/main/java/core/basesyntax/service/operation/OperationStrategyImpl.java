package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation type cannot be null");
        }
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + operation);
        }
        return handler;
    }
}
