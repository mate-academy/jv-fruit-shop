package core.basesyntax.service.operationhandler;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}
