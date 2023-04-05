package core.basesyntax.service.handlerfruits;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction fruitTransaction);
}
