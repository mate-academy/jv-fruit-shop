package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void perform(FruitTransaction fruitTransaction);
}
