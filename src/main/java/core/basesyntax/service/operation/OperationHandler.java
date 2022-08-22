package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Fruit handle(FruitTransaction fruitTransaction);
}
