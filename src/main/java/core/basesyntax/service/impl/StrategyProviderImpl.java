package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyProvider;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyProviderImpl implements StrategyProvider {
    private final Map<FruitTransaction.Operation, OperationStrategy> strategyMap = new HashMap<>();

    @Override
    public void setStrategy(FruitTransaction.Operation key, OperationStrategy strategy) {
        this.strategyMap.put(key, strategy);
    }

    @Override
    public OperationStrategy getStrategy(FruitTransaction.Operation key) {
        return strategyMap.get(key);
    }
}
