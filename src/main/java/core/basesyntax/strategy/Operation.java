package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface Operation {
    void performOperation(FruitTransaction fruitTransaction);
}
