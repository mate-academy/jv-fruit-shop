package core.basesyntax.service.handlers;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class SupplyHandler implements OperationHandler {

    @Override
    public void handler(String fruit, int amount) {
        if (Storage.storage.containsKey(fruit)) {
            Integer quantity = Storage.storage.get(fruit);
            Storage.storage.put(fruit, quantity + amount);
        } else {
            Storage.storage.put(fruit, amount);
        }
    }
}
