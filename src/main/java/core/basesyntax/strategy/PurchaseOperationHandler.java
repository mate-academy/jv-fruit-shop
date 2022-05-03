package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.storage.get(fruit);
        if (initialQuantity < quantity) {
            throw new RuntimeException("There's no such quantity of " + fruit.getName() + "'s");
        }
        Storage.storage.put(fruit, initialQuantity - quantity);
    }
}
