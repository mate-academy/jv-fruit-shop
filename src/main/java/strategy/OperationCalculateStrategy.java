package strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class OperationCalculateStrategy {
    private final Map<FruitTransaction.Operation, OperationCalculate> countStrategyMap;

    public OperationCalculateStrategy(Map<FruitTransaction.Operation,
            OperationCalculate> countStrategyMap) {
        this.countStrategyMap = countStrategyMap;
    }

    public OperationCalculate getCountStrategy(FruitTransaction.Operation operation) {
        return Optional.of(countStrategyMap.get(operation))
                .orElseThrow(() -> new RuntimeException("Wrong operation type " + operation));
    }
}
