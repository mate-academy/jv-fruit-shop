package core.basesyntax.handlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    public void process(Fruit fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }
}
