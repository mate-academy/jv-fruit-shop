package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handler.WorkWithFruits;
import java.util.Map;

public class FruitWorkStrategyImp implements FruitWorkStrategy {
    private final Map<Operation, WorkWithFruits> workStrategyWithFruit;

    public FruitWorkStrategyImp(Map<Operation, WorkWithFruits> workStrategyWithFruit) {
        this.workStrategyWithFruit = workStrategyWithFruit;
    }

    @Override
    public WorkWithFruits get(Operation key) {
        return workStrategyWithFruit.get(key);
    }
}
