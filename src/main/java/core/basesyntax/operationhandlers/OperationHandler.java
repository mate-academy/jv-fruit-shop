package core.basesyntax.operationhandlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
