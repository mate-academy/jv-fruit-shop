package core.basesyntax.stategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, FruitOperationHandler> fruitOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            FruitOperationHandler> fruitOperationHandlerMap) {
        this.fruitOperationHandlerMap = fruitOperationHandlerMap;
    }

    @Override
    public FruitOperationHandler getHandler(Operation operation) {
        FruitOperationHandler handler = fruitOperationHandlerMap.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for operation: " + operation);
        }
        return handler;
    }
}
