package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class OperationCalculatorStrategy {
    private final Map<FruitTransaction.Operation, OperationCalculator> countStrategyMap;

    public OperationCalculatorStrategy(Map<FruitTransaction.Operation,
            OperationCalculator> countStrategyMap) {
        this.countStrategyMap = countStrategyMap;
    }

    public OperationCalculator getCountStrategy(FruitTransaction.Operation operation) {
        return Optional.of(countStrategyMap.get(operation))
                .orElseThrow(() -> new RuntimeException("Wrong operation type -> " + operation));
    }
}
