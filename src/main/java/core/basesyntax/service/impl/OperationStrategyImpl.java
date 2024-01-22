package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Fruit.Operation,OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Fruit.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Fruit.Operation type) {
        OperationHandler handler = operationHandlerMap.get(type);
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported operation type: " + type);
        }
        return handler;
    }
}
