package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> typeStrategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> typeStrategyMap) {
        this.typeStrategyMap = typeStrategyMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return typeStrategyMap.get(operation);
    }
}
