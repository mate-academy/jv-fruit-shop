package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.TypeStrategy;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, TypeStrategy> typeStrategyMap;

    public FruitStrategyImpl(Map<FruitTransaction.Operation, TypeStrategy> typeStrategyMap) {
        this.typeStrategyMap = typeStrategyMap;
    }

    @Override
    public TypeStrategy get(FruitTransaction.Operation operation) {
        return typeStrategyMap.get(operation);
    }
}
