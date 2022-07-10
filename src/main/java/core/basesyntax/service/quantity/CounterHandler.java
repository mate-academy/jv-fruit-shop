package core.basesyntax.service.quantity;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface CounterHandler {
    void calculateQuantity(Fruit fruit, FruitTransaction transaction);
}
