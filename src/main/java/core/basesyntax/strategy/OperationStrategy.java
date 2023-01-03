package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.Optional;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, CountStrategy> countStrategyMap;

    public OperationStrategy(Map<FruitTransaction.Operation, CountStrategy> countStrategyMap) {
        this.countStrategyMap = countStrategyMap;
    }

    public CountStrategy getCountStrategyMap(FruitTransaction.Operation operation) {
        Optional<CountStrategy> optionalCountStrategy
                = Optional.of(countStrategyMap.get(operation));
        return optionalCountStrategy
                .orElseThrow(() -> new RuntimeException("Wrong operation type -> " + operation));
    }
}
