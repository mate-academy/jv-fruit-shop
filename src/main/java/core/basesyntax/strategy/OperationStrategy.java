package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationService> operationServiceMap;

    public OperationStrategy(Map<String, OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public OperationService getOperation(String key) {
        return operationServiceMap.get(key);
    }
}
