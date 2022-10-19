package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.HandlerOperation;
import core.basesyntax.strategy.HandlerOperationStrategy;
import java.util.Map;

public class HandlerOperationImplStrategy implements HandlerOperationStrategy {
    private final Map<String, HandlerOperation> operationHandlerMap;

    public HandlerOperationImplStrategy(Map<String, HandlerOperation> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public HandlerOperation get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
