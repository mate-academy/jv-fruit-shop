package core.basesyntax.handlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class ReturnOperationHandler implements OperationHandler {
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit,
                initialQuantity == null
                        ? quantity
                        : initialQuantity + quantity);
    }
}
