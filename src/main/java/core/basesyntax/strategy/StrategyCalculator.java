package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface StrategyCalculator {
    void calculate(FruitTransaction fruitTransaction);
}
