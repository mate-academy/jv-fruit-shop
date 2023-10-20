package core.basesyntax.service.counter;

import core.basesyntax.service.transaction.FruitTransaction;

public interface OperationHandler {

    void handle(FruitTransaction fruitTransaction);
}
