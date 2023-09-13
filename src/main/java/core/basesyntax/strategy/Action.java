package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface Action {
    void action(FruitTransaction fruitTransaction);
}
