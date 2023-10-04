package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();

    @Override
    public void setStrategy(FruitTransaction.Operation key, OperationHandler strategy) {
        this.strategyMap.put(key, strategy);
    }

    @Override
    public OperationHandler getStrategy(FruitTransaction.Operation key) {
        return strategyMap.get(key);
    }
}
