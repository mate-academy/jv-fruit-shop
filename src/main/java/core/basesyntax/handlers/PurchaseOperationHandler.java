package core.basesyntax.handlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.storage.get(fruit);
        if (quantity > initialQuantity) {
            throw new RuntimeException("Not enough fruit");
        }
        Storage.storage.put(fruit, initialQuantity - quantity);
    }
}
