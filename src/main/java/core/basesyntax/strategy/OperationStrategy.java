package core.basesyntax.strategy;

import static core.basesyntax.model.FruitTransaction.Operation;

import java.util.Map;

public class OperationStrategy {
    private final Map<Operation, OperationHandler> strategyMap;

    public OperationStrategy(Map<Operation, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public OperationHandler getHandlerFor(Operation operation) {
        return strategyMap.get(operation);
    }
}
