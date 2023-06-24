package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface CalculationStrategy {
    void calculate(FruitTransaction transaction);
}
