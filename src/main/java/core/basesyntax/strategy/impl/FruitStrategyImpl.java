package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationsStrategy;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, OperationsStrategy> operationsStrategyMap;

    public FruitStrategyImpl(Map<FruitTransaction.Operation,
            OperationsStrategy> operationsStrategyMap) {
        this.operationsStrategyMap = operationsStrategyMap;
    }

    @Override
    public OperationsStrategy get(FruitTransaction.Operation operation) {
        return operationsStrategyMap.get(operation);
    }
}
