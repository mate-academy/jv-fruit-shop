package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationHandler {
    private final Map<FruitTransaction.Operation, OperationStrategy> strategyMap;

    public OperationHandler() {
        strategyMap = new HashMap<>();
    }

    public Map<FruitTransaction.Operation, OperationStrategy> getStrategyMap() {
        return strategyMap;
    }

    public OperationStrategy getStrategy(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
