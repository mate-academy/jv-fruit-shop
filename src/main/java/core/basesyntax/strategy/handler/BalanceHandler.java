package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance cannot be negative");
        }
        fruit.setQuantity(quantity);
        Storage.fruits.put(fruit.getName(), fruit);
    }
}
