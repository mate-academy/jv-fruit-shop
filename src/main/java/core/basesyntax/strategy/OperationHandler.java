package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Fruit performOperation(FruitTransaction fruitTransaction);
}
