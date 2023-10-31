package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitHandlerStrategy;
import java.util.Map;

public class FruitHandlerStrategyImpl implements FruitHandlerStrategy {
    private final Map<FruitTransaction.Operation, FruitHandler> strategy;

    public FruitHandlerStrategyImpl(Map<FruitTransaction.Operation, FruitHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public FruitHandler getHandler(FruitTransaction.Operation operation) {
        if (operation != null) {
            return strategy.get(operation);
        } else {
            throw new RuntimeException("Operation is null in "
                    + getClass().getSimpleName());
        }
    }
}
