package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

public interface OperationHandler {

    void handle(FruitTransaction fruitTransaction);
}
