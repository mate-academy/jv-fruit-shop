package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;

public class FruitWorkStrategyImpl implements FruitWorkStrategy {
    private final Map<Operation, OperationHandler> workStrategyWithFruit;

    public FruitWorkStrategyImpl(Map<Operation, OperationHandler> workStrategyWithFruit) {
        this.workStrategyWithFruit = workStrategyWithFruit;
    }

    @Override
    public OperationHandler get(Operation key) {
        return workStrategyWithFruit.get(key);
    }
}
