package core.basesyntax.handlers;

import core.basesyntax.storage.Storage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Storage.storage.merge(fruit, quantity, Integer::sum);
    }
}
