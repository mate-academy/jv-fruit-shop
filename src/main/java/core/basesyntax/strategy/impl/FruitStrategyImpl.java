package core.basesyntax.strategy.impl;

import core.basesyntax.OperationsStrategy;
import core.basesyntax.model.Fruit;
import core.basesyntax.FruitStrategy;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Fruit.Operation, OperationsStrategy> operationsStrategyMap;

    public FruitStrategyImpl(Map<Fruit.Operation,
            OperationsStrategy> operationsStrategyMap) {
        this.operationsStrategyMap = operationsStrategyMap;
    }

    @Override
    public OperationsStrategy get(Fruit.Operation operation) {
        return operationsStrategyMap.get(operation);
    }
}
