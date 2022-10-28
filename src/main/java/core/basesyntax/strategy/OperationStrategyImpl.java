package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> operationServiceMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public OperationHandler getOperation(String key) {
        return operationServiceMap.get(key);
    }
}
