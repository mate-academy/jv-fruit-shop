package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitHandler {
    void calculateFruitOperation(FruitTransaction fruitTransaction);
}
