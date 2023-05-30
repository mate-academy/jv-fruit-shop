package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
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
