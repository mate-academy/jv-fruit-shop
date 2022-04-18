package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface Strategy {
    void handle(FruitTransaction fruitTransaction);
}
