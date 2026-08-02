package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.EnumMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        if (operationHandlers == null) {
            throw new IllegalArgumentException("Operation handlers cannot be null");
        }
        this.operationHandlers = new EnumMap<>(FruitTransaction.Operation.class);
        this.operationHandlers.putAll(operationHandlers);
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        OperationHandler operationHandler = operationHandlers.get(operation);
        if (operationHandler == null) {
            throw new RuntimeException("No handler for operation: " + operation);
        }
        return operationHandler;
    }
}
