package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyHandler {
    void handle(FruitTransaction fruitTransaction);
}
