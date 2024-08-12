package core.basesyntax.service.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void transaction(FruitTransaction fruitTransaction, Fruit fruit);
}
