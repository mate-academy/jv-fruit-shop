package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, QuantityCalculationStrategy> operationsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            QuantityCalculationStrategy> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public QuantityCalculationStrategy get(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
