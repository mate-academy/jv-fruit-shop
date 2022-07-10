package core.basesyntax.service.quantity;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class ReturnCounterHandler implements CounterHandler {
    @Override
    public void calculateQuantity(Fruit fruit, FruitTransaction transaction) {
        fruit.setQuantity(fruit.getQuantity() + transaction.getQuantity());
    }
}
