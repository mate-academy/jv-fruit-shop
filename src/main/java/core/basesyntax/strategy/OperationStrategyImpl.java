package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.map = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (!map.containsKey(operation)) {
            throw new RuntimeException("Unknown operation - " + operation);
        }
        return map.get(operation);
    }
}
