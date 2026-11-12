package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        if (handlersMap == null) {
            throw new IllegalArgumentException("The handlers map cannot be null.");
        }
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("The operation cannot be null.");
        }
        OperationHandler handler = handlersMap.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler for operation: " + operation);
        }
        return handler;
    }
}
