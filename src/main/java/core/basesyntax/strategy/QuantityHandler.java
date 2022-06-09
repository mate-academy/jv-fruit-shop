package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface QuantityHandler {
    Integer getQuantity(FruitTransaction fruitTransaction);
}
