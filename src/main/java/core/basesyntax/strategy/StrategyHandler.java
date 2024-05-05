package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyHandler {
    int doStrategy(FruitTransaction fruitTransaction);
}
