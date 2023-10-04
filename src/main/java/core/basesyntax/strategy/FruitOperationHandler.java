package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitOperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
