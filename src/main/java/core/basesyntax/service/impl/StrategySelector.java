package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.*;

import java.util.Map;

public class StrategySelector {
    private final Map<FruitTransaction.Operation, SaveStrategy> strategies;
    public StrategySelector(Map<FruitTransaction.Operation, SaveStrategy> strategies) {
        this.strategies = strategies;
    }

    public SaveStrategy selectStrategy(FruitTransaction.Operation operation) {
        if (!strategies.containsKey(operation)) {
            throw new RuntimeException("Failed to choose strategy for operation " + operation.name());
        }
        return strategies.get(operation);
    }
}
