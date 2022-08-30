package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandlerImplStrategy implements OperationHandlerStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationHandlerImplStrategy(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(String operation) {
        return operationHandlerMap.get(operation);
    }
}
