package core.basesyntax.services;

import core.basesyntax.services.handlers.FruitHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private final Map<String, FruitHandler> fruitStrategy;

    public FruitStrategyImpl(Map<String, FruitHandler> fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public FruitHandler getHandler(String typeOperation) {
        return fruitStrategy.get(typeOperation);
    }
}
