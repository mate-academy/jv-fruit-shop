package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationStrategyImpl> operationServiceMap;

    public OperationStrategy(Map<String, OperationStrategyImpl> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public OperationStrategyImpl getOperation(String key) {
        return operationServiceMap.get(key);
    }
}
