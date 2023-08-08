package core.basesyntax.service.handlers;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handler(String fruit, int amount) {
        Integer quantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, quantity + amount);
    }
}
