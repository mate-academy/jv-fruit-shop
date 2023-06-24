package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface CalculatorStrategy {
    void calculate(FruitTransaction transaction);
}
