package core.basesyntax.services;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.services.handlers.FruitHandler;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private final Map<String, FruitHandler> fruitStrategy;

    public FruitStrategyImpl(Map<String, FruitHandler> fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public FruitHandler getHandler(String typeOperation) {
        for (Map.Entry<String, FruitHandler> strategy : fruitStrategy.entrySet()) {
            if (strategy.getKey().equals(typeOperation)) {
                return strategy.getValue();
            }
        }
        throw new ValidationException("Can't found this type of operation");
    }
}
