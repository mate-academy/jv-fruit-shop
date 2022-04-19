package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyOperation {
    void handle(FruitTransaction fruitTransaction);
}
