package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TypeStrategy {
    void handle(FruitTransaction fruitTransaction);
}
