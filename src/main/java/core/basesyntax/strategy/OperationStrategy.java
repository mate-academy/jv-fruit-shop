package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyMap;

    public OperationStrategy(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.strategyMap = operationHandlerMap;
    }

    public OperationHandler get(FruitTransaction.Operation type) {
        return strategyMap.get(type);
    }
}
