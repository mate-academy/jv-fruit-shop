package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer getQuantity(FruitTransaction fruitTransaction);
}
