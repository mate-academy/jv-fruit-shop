package core.basesyntax.strategy;

import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private final Map<String, OperationHandler> map;

    public FruitStrategyImpl(Map<String, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getByOperation(String operation) {
        return map.getOrDefault(operation, null);
    }
}
