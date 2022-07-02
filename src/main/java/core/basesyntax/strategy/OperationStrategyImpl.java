package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Fruit.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<Fruit.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler get(Fruit.Operation operation) {
        return map.get(operation);
    }
}
