package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction fruitTransaction);
}
