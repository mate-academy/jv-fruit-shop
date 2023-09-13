package core.basesyntax.strategy.handlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
