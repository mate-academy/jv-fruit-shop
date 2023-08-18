package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationHandlerHashMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerHashMap) {
        this.operationHandlerHashMap = operationHandlerHashMap;
    }

    @Override
    public OperationHandler getOperationService(String letter) {
        return operationHandlerHashMap.get(letter);
    }
}
