package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler handler = handlersMap.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler for operation: " + operation);
        }
        return handler;
    }
}
