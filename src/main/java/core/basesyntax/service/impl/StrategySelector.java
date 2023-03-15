package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.SaveStrategy;
import java.util.Map;

public class StrategySelector {
    private final Map<Operation, SaveStrategy> strategies;

    public StrategySelector(Map<Operation, SaveStrategy> strategies) {
        this.strategies = strategies;
    }

    public SaveStrategy selectStrategy(Operation operation) {
        if (!strategies.containsKey(operation)) {
            throw new RuntimeException(
                    "Failed to choose strategy for operation " + operation.name());
        }
        return strategies.get(operation);
    }
}
