package core.basesyntax.store.handler;

import core.basesyntax.store.model.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction fruitTransaction);
}
