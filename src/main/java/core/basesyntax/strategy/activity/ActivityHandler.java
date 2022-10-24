package core.basesyntax.strategy.activity;

import core.basesyntax.model.FruitTransaction;

public interface ActivityHandler {
    void doActivity(FruitTransaction fruitTransaction);
}
