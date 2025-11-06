package core.basesyntax.provider;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class StrategyProvider {
    private final Map<Operation, OperationStrategy> strategyMap;

    public StrategyProvider(Map<Operation, OperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public OperationStrategy get(Operation operation) {
        return this.strategyMap.get(operation);
    }
}
