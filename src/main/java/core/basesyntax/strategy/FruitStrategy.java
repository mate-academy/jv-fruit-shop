package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitStrategy {
    void operate(FruitTransaction fruitTransaction);
}
