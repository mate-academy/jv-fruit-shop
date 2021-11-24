package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operate(String fruitName, int quantity) {
        int oldQuantity = Storage.storage.get(new Fruit(fruitName));
        int actual = oldQuantity - quantity;
        if (actual > 0) {
            Storage.storage.put(new Fruit(fruitName), actual);
        } else {
            throw new RuntimeException("We don't have such fruits in the store");
        }
    }
}
