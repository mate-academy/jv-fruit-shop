package core.basesyntax.services.handlers;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {
    void handleOperation(FruitTransaction fruitTransaction);
}
