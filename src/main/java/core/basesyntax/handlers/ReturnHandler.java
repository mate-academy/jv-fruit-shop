package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        int currentQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, currentQuantity + quantity);
    }
}
