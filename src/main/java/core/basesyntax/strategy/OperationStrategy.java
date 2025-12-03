package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> strategyMap;

    public OperationStrategy(Map<Operation, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public OperationHandler getStrategy(Operation operation) {
        if (!strategyMap.containsKey(operation)) {
            throw new IllegalArgumentException("Strategy not found: " + operation);
        }
        return strategyMap.get(operation);
    }
}
