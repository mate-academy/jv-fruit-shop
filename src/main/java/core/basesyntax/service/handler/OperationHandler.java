package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Fruit;

public interface OperationHandler {
    void transaction (FruitTransaction fruitTransaction, Fruit fruit);
}
