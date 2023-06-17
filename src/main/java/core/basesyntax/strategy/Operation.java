package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface Operation {
    void doOperation(FruitTransaction transaction);
}
