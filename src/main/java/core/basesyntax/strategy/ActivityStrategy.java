package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ActivityStrategy {
    void doActivity(FruitTransaction fruitTransaction);
}
