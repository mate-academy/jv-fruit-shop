package core.basesyntax.strategy;

import core.basesyntax.service.handler.WorkWithFruits;
import java.util.Map;

public class FruitWorkStrategyImp implements FruitWorkStrategy {
    private final Map<String, WorkWithFruits> workStrategyWithFruit;

    public FruitWorkStrategyImp(Map<String, WorkWithFruits> workStrategyWithFruit) {
        this.workStrategyWithFruit = workStrategyWithFruit;
    }

    @Override
    public WorkWithFruits get(String key) {
        return workStrategyWithFruit.get(key);
    }
}
