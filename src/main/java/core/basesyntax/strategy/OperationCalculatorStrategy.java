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
        Optional<OperationCalculator> optionalCountStrategy
                = Optional.of(countStrategyMap.get(operation));
        return optionalCountStrategy
                .orElseThrow(() -> new RuntimeException("Wrong operation type -> " + operation));
    }
}
