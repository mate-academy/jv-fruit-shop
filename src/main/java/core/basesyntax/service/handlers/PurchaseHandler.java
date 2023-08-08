package core.basesyntax.service.handlers;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handler(String fruit, int amount) {
        Integer quantity = Storage.storage.get(fruit);
        if (quantity - amount < 0) {
            throw new IllegalArgumentException("Amount can`t be less then zero,"
                    + " can`t sell more then we have");
        }
        Storage.storage.put(fruit, quantity - amount);
    }
}
