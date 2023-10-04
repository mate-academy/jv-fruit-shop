package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationsStrategyMap;

    public FruitStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationsStrategyMap) {
        this.operationsStrategyMap = operationsStrategyMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationsStrategyMap.get(operation);
    }
}
