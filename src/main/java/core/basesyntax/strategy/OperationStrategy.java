package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategy {
    private Map<String, OperationHandler> strategyMap;

    public OperationStrategy(Map<String, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public OperationHandler getByOperation(String operation) {
        return strategyMap.get(operation);
    }
}
