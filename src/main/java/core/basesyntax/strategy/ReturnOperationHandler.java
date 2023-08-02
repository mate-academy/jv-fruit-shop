package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit, Integer quantity) {
        int newValueAfterReturning = Storage.getStorage().get(fruit) + quantity;
        Storage.getStorage().put(fruit, newValueAfterReturning);
    }
}
