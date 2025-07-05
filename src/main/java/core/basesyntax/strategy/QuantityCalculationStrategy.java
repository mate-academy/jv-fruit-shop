package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface QuantityCalculationStrategy {
    void calculate(FruitTransaction fruitTransaction);
}
